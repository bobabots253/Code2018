
package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class swingOutL extends Command {
	
	public swingOutL(){
		requires(Robot.arms);
	}
	
	protected void execute(){
		Robot.arms.swingOutL();
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