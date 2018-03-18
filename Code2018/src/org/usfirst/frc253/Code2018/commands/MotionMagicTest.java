package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;
import org.usfirst.frc253.Code2018.profiles.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Command;

public class MotionMagicTest extends Command{

	private TalonSRX left;
	private TalonSRX right;
	
	private double target;
	
	public MotionMagicTest(double target){
		left = Robot.driveTrain.getLeftBack();
		right = Robot.driveTrain.getRightFront();
		
		this.target = target;
		
		left.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
		left.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);
		
		right.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
		right.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);
		
		left.configNominalOutputForward(0, Constants.kTimeoutMs);
		left.configNominalOutputReverse(0, Constants.kTimeoutMs);
		left.configPeakOutputForward(1, Constants.kTimeoutMs);
		left.configPeakOutputReverse(-1, Constants.kTimeoutMs);
		
		right.configNominalOutputForward(0, Constants.kTimeoutMs);
		right.configNominalOutputReverse(0, Constants.kTimeoutMs);
		right.configPeakOutputForward(1, Constants.kTimeoutMs);
		right.configPeakOutputReverse(-1, Constants.kTimeoutMs);
		
		left.configMotionCruiseVelocity(3650, Constants.kTimeoutMs);
		left.configMotionAcceleration(1825, Constants.kTimeoutMs);
		
		right.configMotionCruiseVelocity(3650, Constants.kTimeoutMs);
		right.configMotionAcceleration(1825, Constants.kTimeoutMs);
		
		left.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		right.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
	}
	
	protected void execute(){
		double sensorUnits = target / (0.5 * Math.PI) * 4096;
		left.set(ControlMode.MotionMagic, sensorUnits);
		right.set(ControlMode.MotionMagic, sensorUnits);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
