package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
//command for bringing sweeper-thingys back in the elevator after depositing cube 
public class sweepBack extends Command {
	boolean isTimed;
    public sweepBack() {
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	isTimed = false;
    }
    //makes sweepBack timed
    public sweepBack(double time){
    	isTimed = true;
    	setTimeout(time);
    	requires(Robot.elevator);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.sweepBackward();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(isTimed){
    		return isTimedOut();
    	}else{ 
    		return false;   
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevator.sweepStop();
    }
}
