package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinRightIntake extends Command {

	protected void execute(){
		Robot.intake.spinRight();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		Robot.intake.stop();
	}
	
	protected void interrupted(){
		Robot.intake.stop();
	}

}
