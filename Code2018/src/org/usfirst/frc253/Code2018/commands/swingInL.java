

package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class swingInL extends Command {
	
	public swingInL(){
		requires(Robot.arms);
	}
	
	protected void execute(){
		Robot.arms.swingInL();
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