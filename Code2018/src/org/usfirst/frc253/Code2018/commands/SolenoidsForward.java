package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SolenoidsForward extends Command{

	public SolenoidsForward(){
		requires(Robot.pneumatics);
		setTimeout(0.5);
	}
	
	protected void execute(){
		Robot.pneumatics.doubleSolenoid1Forward();
		Robot.pneumatics.doubleSolenoid2Forward();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

}
