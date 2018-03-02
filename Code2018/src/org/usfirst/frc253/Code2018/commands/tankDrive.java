//Justin and Fiona
// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc253.Code2018.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc253.Code2018.Robot;
import edu.wpi.first.wpilibj.XboxController;

/**
 *
 */
public class tankDrive extends Command {
	boolean changeStatus = true;
	boolean toggle = true;
	double kDeadzone = 0.125; //How far you have to push the joystick to get a response (0.125 = 1/8th of full)
		
    public tankDrive() {

    	//says we need drivetrain to do this command 
        requires(Robot.driveTrain);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double left;
        double right;
        if(!(Robot.oi.keyboard.getRawButton(4) || Robot.oi.keyboard.getRawButton(5))){
        	left = Robot.oi.getTurn();
        	right = -Robot.oi.getTurn();
        }else{
    		left = Robot.oi.getThrottle()-Robot.oi.getThrottle()*Robot.oi.getTurn();
    		right = Robot.oi.getThrottle()+Robot.oi.getThrottle()*Robot.oi.getTurn();
    	}
        	
        Robot.driveTrain.drive(left, right);
    	
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
