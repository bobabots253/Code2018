package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmsControl extends Command{

	public ArmsControl(){
		requires(Robot.arms);
	}
	
	protected void execute(){
		double speed = Robot.oi.getOperatorJoystick2().getY();
		
		if(Math.abs(speed) < 0.075){
			Robot.arms.swingStop();
		} else {
			Robot.arms.swing(speed);
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
