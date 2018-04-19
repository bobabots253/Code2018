package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Ejecthalf extends Command {
	boolean isTimed;
	public Ejecthalf(double time){
		isTimed = true;
		setTimeout(time);
		requires(Robot.intake);
	}
	public Ejecthalf() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    	isTimed = false; 
	}
	
	
	protected void execute(){
		Robot.intake.ejecthalf();
	}

	@Override
	protected boolean isFinished() {
		if(isTimed){ 
    		return isTimedOut(); 
    	}else{ 
    		return false;
    	}
	}
	
	protected void end(){
		Robot.intake.stop();
	}
	
	protected void interrupted(){
		Robot.intake.stop();
	}

}
