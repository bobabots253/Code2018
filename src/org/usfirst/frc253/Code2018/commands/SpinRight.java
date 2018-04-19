package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinRight extends Command{

	public SpinRight(){
		requires(Robot.driveTrain);
	}
	
	protected void execute(){
		Robot.driveTrain.drive(-.5, .5);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		Robot.driveTrain.drive(0, 0);
	}
	
	protected void interrupted(){
		Robot.driveTrain.drive(0, 0);
	}

}
