package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SolenoidsReverse extends Command{

	public SolenoidsReverse(){
		requires(Robot.pneumatics);
		setTimeout(0.5);
	}
	
	protected void execute(){
		Robot.pneumatics.doubleSolenoid1Reverse();
		Robot.pneumatics.doubleSolenoid2Reverse();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

}
