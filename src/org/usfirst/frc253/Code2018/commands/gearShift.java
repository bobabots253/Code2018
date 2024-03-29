package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
//command for shifting gears 
public class gearShift extends Command {
	boolean changeStatus = true;
	boolean toggle = true;
	public gearShift() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.pneumatics);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		boolean isPressedTurnedOn = Robot.oi.xboxController.getTriggerAxis(Hand.kLeft) > 0.1;
		
		if(isPressedTurnedOn && toggle) {
			toggle = false;
			changeStatus = !changeStatus;
		}
		else if(!isPressedTurnedOn) {
			toggle = true;
		}
		if(!changeStatus) {
			Robot.pneumatics.doubleSolenoid1Forward();
		} else {
			Robot.pneumatics.doubleSolenoid1Reverse();
		}
	}



	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
