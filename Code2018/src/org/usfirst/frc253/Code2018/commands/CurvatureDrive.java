package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class CurvatureDrive extends Command{

	private static final double skimGain = 1;
	private static final double turnGain = 1;
	
	public CurvatureDrive(){
		requires(Robot.driveTrain);
		setName("Curvature Drive");
	}
	
	protected void execute(){
		double throttle = Robot.oi.getLeftJoystickY();
		double turn = Robot.oi.getRightJoystickX();
		
		if(!Robot.oi.xboxController.getStickButton(Hand.kLeft)){
			turn *= turnGain * Math.abs(throttle);
		}
		
		double tempLeft = throttle - turn;
		double tempRight = throttle + turn;
		
		double left = tempLeft + skim(tempRight);
		double right = tempRight + skim(tempLeft);
		
		Robot.driveTrain.drive(left, right);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	private static double skim(double num){
		if(num > 1.0){
			return -((num - 1.0) * skimGain);
		} else if(num < -1.0){
			return -((num + 1.0) * skimGain);
		} else {
			return 0;
		}
	}
}
