package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SolenoidIntakeReverse extends Command{
	
	boolean isTimed;
	
	public SolenoidIntakeReverse(){
		isTimed = false;
	}
	
	public SolenoidIntakeReverse(double time){
		setTimeout(time);
		isTimed = true;
	}
	
	protected void execute(){
		Robot.intake.solenoidIntakeReverse();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimed ? isTimedOut() : false;
	}

}
