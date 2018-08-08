package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StraightDriveSlow extends Command{
	
	public StraightDriveSlow(double time){
		setTimeout(time);
	}
	
	protected void execute(){
		Robot.driveTrain.drive(-.25, -.25);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}
	
	protected void end(){
		Robot.driveTrain.drive(0, 0);
	}
	
	protected void interrupted(){
		Robot.driveTrain.drive(0, 0);
	}

}
