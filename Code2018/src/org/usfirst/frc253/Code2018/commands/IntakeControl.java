package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeControl extends Command{
	
	public IntakeControl(){
		requires(Robot.intake);
	}

	protected void execute(){
		if(Robot.sensors.getLimitSwitch1().get()){
			if(Robot.oi.getOperatorJoystick().getRawButton(3)){
				Robot.intake.insideEject();
			} else if(Robot.oi.getOperatorJoystick().getRawButton(2)){
				Robot.intake.insideIntake();
			} else {
				Robot.intake.insideStop();
			}
		} else {
			Robot.intake.insideStop();
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
