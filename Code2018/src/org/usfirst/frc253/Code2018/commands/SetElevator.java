package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class SetElevator extends PIDCommand{

	public SetElevator(){
		super(0, 0, 0);
	}
	
	protected void execute(){
		
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return Robot.driveTrain.getRightFront().getSelectedSensorPosition(0) / 4096.0; //rot
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
