
package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;
import org.usfirst.frc253.Code2018.profiles.Constants;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

public class SetElevatorReverse extends Command{

	EncoderFollower follower;
	
	public SetElevatorReverse(Trajectory trajec){
		requires(Robot.elevator);
		
		follower = new EncoderFollower(trajec);
		
		follower.configurePIDVA(0.8, 0, 0, 1 / Constants.kElevatorMaxVelMetersPSec, 0.0);
		
		follower.configureEncoder(-Robot.driveTrain.getLeftFront().getSelectedSensorPosition(0), 4096, Constants.kElevatorSprocketDiameterMeters);
	}
	
	public SetElevatorReverse(Trajectory trajec, double timeout){
		this(trajec);
		setTimeout(timeout);
	}
	
	protected void execute(){
		double speed = follower.calculate(-Robot.driveTrain.getLeftFront().getSelectedSensorPosition(0));
		
		Robot.elevator.move(-(0.225 + speed));
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return follower.isFinished() || isTimedOut();
	}
	
	protected void end(){
		Robot.elevator.eleStop();
	}
	
	protected void interrupted(){
		Robot.elevator.eleStop();
	}
	
}
