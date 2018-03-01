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
		double speed = -Robot.oi.keyboard.getRawAxis(2);
		
		Robot.elevator.move(.2 + speed * 0.8);
		
		if(false){ //TODO: too lazy to fix this lol
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
