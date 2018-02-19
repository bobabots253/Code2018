package org.usfirst.frc253.Code2018.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc253.Code2018.*;

/**
 *
 */
//command for moving elevator up 
public class elevatorUp extends Command {
	boolean isTimed;  

    public elevatorUp() {
    	requires(Robot.elevator);
    	isTimed = false; 
    }
    //makes elevatorUp timed 
    public elevatorUp(double time){ 
    	isTimed = true; 
    	setTimeout(time); 
    	requires(Robot.elevator); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.lift();
    	
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
