package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class swingOut extends Command {
	
	public swingOut(){
		requires(Robot.arms);
	}
	
	protected void execute(){
		Robot.arms.swingOut();
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