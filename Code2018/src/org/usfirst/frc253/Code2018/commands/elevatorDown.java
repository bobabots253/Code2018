package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
//command that brings the elevator down 
public class elevatorDown extends Command {
	boolean isTimed; 
    public elevatorDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    	isTimed = false;
    }
   //makes the elevatorDown command timed 
    public elevatorDown(double time){
    	requires(Robot.elevator);
    	setTimeout(time);
    	isTimed = true;
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.lower();
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
    	Robot.elevator.eleStop();
    }
}
