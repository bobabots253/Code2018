package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class insideIntake extends Command {
	boolean isTimed;
	public insideIntake(double time){
		isTimed = true;
		setTimeout(time);
		requires(Robot.intake);
	}
	public insideIntake(){
		isTimed = false;
		requires(Robot.intake);
	}
	
	protected void execute(){
		Robot.intake.insideIntake();
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
		Robot.intake.insideStop();
	}

}