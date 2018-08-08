package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Ejectonly extends Command {
	boolean isTimed;
	public Ejectonly(double time){
		isTimed = true;
		setTimeout(time);
		requires(Robot.intake);
	}
	public Ejectonly() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    	isTimed = false; 
	}
	
	
	protected void execute(){
		Robot.intake.ejectonly();
	}

	@Override
	protected boolean isFinished() {
		if(isTimed){ 
    		return isTimedOut(); 
    	}else{ 
    		return false;
	}
	}
	
	protected void interrupted(){
		Robot.intake.stop();
	}

}