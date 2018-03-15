package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class swingIn extends Command {
	
	public swingIn(){
		requires(Robot.arms);
	}
	
	protected void execute(){
		Robot.arms.swingIn();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void interrupted(){
		Robot.arms.swingStop();
	}

}