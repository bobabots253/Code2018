package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SolenoidShiftReverse extends Command{
	
	public SolenoidShiftReverse(){
		requires(Robot.pneumatics);
	}
	
	protected void execute(){
		Robot.pneumatics.doubleSolenoid1Reverse();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
