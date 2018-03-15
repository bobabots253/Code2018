
package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SetElevator extends PIDCommand{

	public static final double GROUND = 0;
	public static final double SWITCH = 2.104;
	public static final double SCALE = 5.542;
	public static final double PORTAL = 2.25; //bottom is 1 ft 8 in off the ground; portal is 1 ft 2 in high
	
	public SetElevator(double height){
		super(0.1, 0, 0);
		requires(Robot.elevator);
		getPIDController().setSetpoint(height);
		getPIDController().setAbsoluteTolerance(0.2);
		getPIDController().setContinuous(false);
		getPIDController().enable();
	}
	
	protected void execute(){
		SmartDashboard.putNumber("SetElevator Output", getPIDController().get());
		
		Robot.elevator.pidControl(0.225 + getPIDController().get());
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return Robot.driveTrain.getLeftBack().getSelectedSensorPosition(0) / 4096.0 * 1.75 / 12.0 * Math.PI; //feet
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
