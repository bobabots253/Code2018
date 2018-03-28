package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SolenoidIntakeForward extends Command{

	boolean isTimed;
	
	public SolenoidIntakeForward(){
		isTimed = false;
	}
	
	public SolenoidIntakeForward(double time){
		setTimeout(time);
		isTimed = true;
	}
	
	protected void execute(){
		Robot.intake.solenoidIntakeForward();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimed ? isTimedOut() : false;
	}

}
