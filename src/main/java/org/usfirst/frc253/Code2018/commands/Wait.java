package org.usfirst.frc253.Code2018.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command{
	
	public Wait(double time){
		setTimeout(time);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

}
