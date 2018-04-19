package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class KinectDrive extends Command{
	
	public KinectDrive(){
		requires(Robot.driveTrain);
	}
	
	protected void execute(){
		
		double lHandY = Robot.table.getEntry("lHandY").getDouble(0);
		double lHandZ = Robot.table.getEntry("lHandZ").getDouble(0);
		
		double rHandY = Robot.table.getEntry("rHandY").getDouble(0);
		double rHandZ = Robot.table.getEntry("rHandZ").getDouble(0);
		
		double lElbowY = Robot.table.getEntry("lElbowY").getDouble(0);
		double lElbowZ = Robot.table.getEntry("lElbowZ").getDouble(0);
		
		double rElbowY = Robot.table.getEntry("rElbowY").getDouble(0);
		double rElbowZ = Robot.table.getEntry("rElbowZ").getDouble(0);
		
		double left = (lHandZ - lElbowZ) * (4.0 / 3.0);
		double right = (rHandZ - rElbowZ) * (4.0 / 3.0);
		
		SmartDashboard.putNumber("left control", left);
		SmartDashboard.putNumber("right control", right);
		
		boolean leftExceed = Math.abs(left) > .4;
		boolean rightExceed = Math.abs(right) > .4;
		
		boolean leftDeadband = Math.abs(left) < 0.15;
		boolean rightDeadband = Math.abs(right) < 0.15;
		
		Robot.driveTrain.drive(leftExceed ? (0.4) : (leftDeadband ? (0) : (left)), rightExceed ? (0.4) : (rightDeadband ? (0) : (right)));
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}