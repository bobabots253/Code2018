package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmsControl extends Command{

	boolean toggle = true;
	boolean changeStatus = false;
	
	public ArmsControl(){
		requires(Robot.arms);
	}
	
	protected void execute(){
		if(Robot.oi.getOperatorJoystick2().getRawButton(11) && toggle){
			toggle = false;
			changeStatus = !changeStatus;
		} else if(!Robot.oi.getOperatorJoystick2().getRawButton(11)){
			toggle = true;
		}
		
		double speed = Robot.oi.getOperatorJoystick2().getY();
		
		if(Math.abs(speed) > 0.1){
			Robot.arms.swing(speed);
		} else if(changeStatus){
			Robot.arms.swing(.15);
		} else {
			Robot.arms.swing(0);
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
