package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;
import org.usfirst.frc253.Code2018.profiles.Constants;
import org.usfirst.frc253.Code2018.profiles.TrajectoryContainer;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

public class GoToTrajec extends Command{
	
	Trajectory trajecLeft;
	Trajectory trajecRight;
	
	EncoderFollower followerLeft;
	EncoderFollower followerRight;
	
	boolean invert;
	
	public GoToTrajec(TrajectoryContainer container){
		requires(Robot.driveTrain);
		
		Trajectory trajec = container.getTrajec();
		this.invert = container.isInverted();
		
		TankModifier modifier = new TankModifier(trajec);
		modifier.modify(Constants.kWheelBaseWidthMeters); //feet
		trajecLeft = modifier.getLeftTrajectory();
		trajecRight = modifier.getRightTrajectory();
		
		followerLeft = new EncoderFollower(invert ? trajecRight : trajecLeft);
		followerRight = new EncoderFollower(invert ? trajecLeft : trajecRight);
		
		followerLeft.configurePIDVA(Robot.driveTrain.getkP(), Robot.driveTrain.getkI(), Robot.driveTrain.getkD(), 1 / 5.7912, 0);
		followerRight.configurePIDVA(Robot.driveTrain.getkP(), Robot.driveTrain.getkI(), Robot.driveTrain.getkD(), 1 / 5.7912, 0);
		
		followerLeft.configureEncoder(Robot.driveTrain.getLeftBack().getSelectedSensorPosition(0), 4096, Constants.kWheelDiameterMeters);
		followerRight.configureEncoder(Robot.driveTrain.getRightFront().getSelectedSensorPosition(0), 4096, Constants.kWheelDiameterMeters);
	}
	
	protected void initialize(){
		Robot.sensors.resetGyro();
	}
	
	protected void execute(){
		double left = followerLeft.calculate(Robot.driveTrain.getLeftBack().getSelectedSensorPosition(0));
		double right = followerRight.calculate(Robot.driveTrain.getRightFront().getSelectedSensorPosition(0));
		
		double gyroHeading = -Robot.sensors.getYaw();
		
		SmartDashboard.putNumber("Gyro Heading", gyroHeading);
		
		double desiredHeading = Pathfinder.r2d(followerLeft.getHeading()) * (invert ? -1 : 1);
		
		SmartDashboard.putNumber("Desired Heading", desiredHeading);
		
		double angleDifference = Pathfinder.boundHalfDegrees(desiredHeading - gyroHeading);
		
		SmartDashboard.putNumber("Angle Difference", angleDifference);
		
		double turn = 0.8 * (-1.0/80.0) * angleDifference;
		
		Robot.driveTrain.drive(-(left + turn), -(right - turn));
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return followerLeft.isFinished() && followerRight.isFinished();
	}

}
