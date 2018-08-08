package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TakeInHalf extends Command {
	boolean isTimed;
	public TakeInHalf(double time){
		isTimed = true;
		setTimeout(time);
		requires(Robot.intake);
	}
	public TakeInHalf(){
		isTimed = false;
		requires(Robot.intake);
	}
	
	protected void execute(){
		Robot.intake.intakehalf();
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