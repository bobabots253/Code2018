package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ChangeToCurvDrive extends Command{

	public ChangeToCurvDrive(){
		requires(Robot.driveTrain);
		setTimeout(0.1);
	}
	
	protected void execute(){
		Robot.driveTrain.setDefaultCommand(new CurvatureDrive());
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}
	
}