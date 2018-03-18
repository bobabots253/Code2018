package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmsControl extends Command{

	boolean toggle = true;
	boolean changeStatus = true;
	
	public ArmsControl(){
		requires(Robot.arms);
	}
	
	protected void execute(){
		if(Robot.oi.getOperatorJoystick2().getRawButton(8) && toggle){
			toggle = false;
			changeStatus = !changeStatus;
		} else if(!Robot.oi.getOperatorJoystick2().getRawButton(8)){
			toggle = true;
		}
		
		if(changeStatus){
			double speed = Robot.oi.getOperatorJoystick2().getY();
			Robot.arms.swing(speed);
		} else {
			double left = Robot.oi.getOperatorJoystick2().getY();
			double right = Robot.oi.getOperatorJoystick1().getY();
			Robot.arms.swingLeft(left);
			Robot.arms.swingRight(right);
		}
			
		
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
