package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class swingInT extends Command {
	
	public swingInT(){
		requires(Robot.intake);
	}
	
	protected void execute(){
		Robot.intake.swingInT();
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