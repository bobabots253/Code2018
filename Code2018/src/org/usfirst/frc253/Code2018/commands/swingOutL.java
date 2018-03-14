
package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class swingOutL extends Command {
	
	public swingOutL(){
		requires(Robot.intake);
	}
	
	protected void execute(){
		Robot.intake.swingOutL();
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