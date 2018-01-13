package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class doubleSolenoid2Toggle extends Command {
	boolean changeStatus = true;
	boolean toggle = true;

    public doubleSolenoid2Toggle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	boolean isPressedTurnOn = Robot.oi.getRightJoystick().getRawButton(3);
    	if(isPressedTurnOn && toggle){
    		toggle = false;
    		changeStatus = !changeStatus;
    	}else if(!changeStatus){
    		toggle = true;
    	}
    	if(!changeStatus){
    		Robot.pneumatics.doubleSolenoid2Forward();
    	}else{
    		Robot.pneumatics.doubleSolenoid2Reverse();
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
