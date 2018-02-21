package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TakeIn extends Command {
	boolean isTimed;
	public TakeIn(double time){
		isTimed = true;
		setTimeout(time);
		requires(Robot.intake);
	}
	public TakeIn(){
		isTimed = false;
		requires(Robot.intake);
	}
	
	protected void execute(){
		Robot.intake.intake();
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