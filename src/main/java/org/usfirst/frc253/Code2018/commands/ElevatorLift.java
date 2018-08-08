package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorLift extends Command {

	boolean toggle = true;
	boolean changeStatus = true;
	
	public ElevatorLift(){
		requires(Robot.elevator);
	}
	
	protected void execute(){
		if(Robot.oi.getOperatorJoystick2().getRawButton(8) && toggle){
			toggle = false;
			changeStatus = !changeStatus;
		} else if(!Robot.oi.getOperatorJoystick2().getRawButton(8)){
			toggle = true;
		}
		
		if(changeStatus){
			double speed = -Robot.oi.getOperatorJoystick1().getY();
			Robot.elevator.move(.225 + speed * 0.775);
		} else {
			Robot.elevator.move(.225);
		}
		
		if(Robot.oi.xboxController.getYButton()){
			Robot.driveTrain.getLeftFront().setSelectedSensorPosition(0, 0, 0);
		}
		
		SmartDashboard.putNumber("Elevator Encoder", Robot.driveTrain.getLeftFront().getSelectedSensorPosition(0));
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
