package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SetElevator extends PIDCommand{

	
	public SetElevator(Height s){
		super(0.1, 0, 0);
		requires(Robot.elevator);
		getPIDController().setSetpoint(s.getNum());
		getPIDController().setAbsoluteTolerance(0.2);
		getPIDController().setContinuous(false);
		getPIDController().enable();
	}
	
	public enum Height{
		ZERO(0),
		SWITCH(0), //1.5625 feet
		SCALE(0); //5 feet neutral; 4 feet lowest, 6 feet highest
		
		private double pos;
		
		private Height(double p){
			pos = p;
		}
		
		public double getNum(){
			return pos;
		}
	}
	
	protected void execute(){
		SmartDashboard.putNumber("SetElevator Output", getPIDController().get());
		
		Robot.elevator.move(0.2 /*+ getPIDController().get()*/);
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return Robot.driveTrain.getRightFront().getSelectedSensorPosition(0) / 4096.0 / -8.47; //rot
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
