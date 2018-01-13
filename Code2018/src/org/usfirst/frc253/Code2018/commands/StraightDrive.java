package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot; 

import edu.wpi.first.wpilibj.command.Command; 

public class StraightDrive extends Command {
	
	public StraightDrive() {
		requires(Robot.driveTrain); 
	}
	protected void initialize() {
	}
	protected void execute() { 
		Robot.driveTrain.drive(.25, .25); 
	}
	protected boolean isFinished() {
		return false; 
	}
	protected void end() {
		Robot.driveTrain.drive(0, 0); 
	} 
	protected void interrupted() {
		Robot.driveTrain.drive(0, 0); 
	} 
	
}


