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
				Robot.intake.eject();
			} else if(Robot.oi.getOperatorJoystick().getRawButton(2)){
				Robot.intake.intake();
			} else {
				Robot.intake.stop();
			}
		} else {
			Robot.intake.stop();
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
