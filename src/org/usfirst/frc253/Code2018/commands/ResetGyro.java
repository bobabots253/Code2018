package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetGyro extends Command{
	
	public ResetGyro(){
		requires(Robot.sensors);
	}
	
	protected void execute(){
		Robot.sensors.resetGyro();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
