package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot; 

import edu.wpi.first.wpilibj.command.Command; 

public class StraightDrive extends Command {
	
	public StraightDrive() {
		requires(Robot.driveTrain);
		setTimeout(3.5);
	}
	protected void initialize() {
	}
	protected void execute() { //makes robot go straight at specified speed
		Robot.driveTrain.drive(-.5, -.5); 
	}
	protected boolean isFinished() {
		return isTimedOut(); 
	}
	protected void end() {
		Robot.driveTrain.drive(0, 0); 
	} 
	protected void interrupted() {
		Robot.driveTrain.drive(0, 0); 
	} 
	
}


