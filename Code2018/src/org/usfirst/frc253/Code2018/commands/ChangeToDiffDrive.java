package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ChangeToDiffDrive extends Command{

	public ChangeToDiffDrive(){
		requires(Robot.driveTrain);
		setTimeout(0.1);
	}

	protected void execute(){
		Robot.driveTrain.setDefaultCommand(new tankDrive());
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

}
