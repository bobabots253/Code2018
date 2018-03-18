package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeControl extends Command{

	protected void execute(){
		if(Robot.sensors.getLimitSwitch1().get()){
			Robot.intake.hold();
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
