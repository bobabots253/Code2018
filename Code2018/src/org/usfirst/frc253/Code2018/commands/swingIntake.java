package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class swingIntake extends Command {
	
	public swingIntake(){
		requires(Robot.intake);
	}
	
	protected void execute(){
		Robot.intake.swingIntake();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void interrupted(){
		Robot.intake.swingStop();
	}

}