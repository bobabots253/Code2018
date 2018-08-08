package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SolenoidShiftForward extends Command{
	
	public SolenoidShiftForward(){
		requires(Robot.pneumatics);
	}
	
	protected void execute(){
		Robot.pneumatics.doubleSolenoid1Forward();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
