package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorLift extends Command {

	public ElevatorLift(){
		requires(Robot.elevator);
	}
	
	protected void execute(){
		double speed = -Robot.oi.getOperatorJoystick().getY();
		
		Robot.elevator.move(.225 + speed * 0.775);
		
		if(Robot.oi.xboxController.getYButton()){
			Robot.driveTrain.getRightFront().setSelectedSensorPosition(0, 0, 0);
		}
		
		SmartDashboard.putNumber("Elevator Encoder", Robot.driveTrain.getRightFront().getSelectedSensorPosition(0)/ 4096.0 * 1.75 / 12.0 * Math.PI);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
