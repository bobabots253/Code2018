package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class KinectDrive extends Command{

	NetworkTable table;
	
	public KinectDrive(){
		requires(Robot.driveTrain);
		table = NetworkTableInstance.getDefault().getTable("KinectData");
	}
	
	protected void execute(){
		SmartDashboard.putNumber("rightHandX", table.getEntry("rHandX").getDouble(0));
		SmartDashboard.putNumber("rightHandY", table.getEntry("rHandY").getDouble(0));
		SmartDashboard.putNumber("rightHandZ", table.getEntry("rHandZ").getDouble(0));
		
		SmartDashboard.putNumber("centerShoulderX", table.getEntry("cShoulderX").getDouble(0));
		SmartDashboard.putNumber("centerShoulderY", table.getEntry("cShoulderY").getDouble(0));
		SmartDashboard.putNumber("centerShoulderZ", table.getEntry("cShoulderZ").getDouble(0));
		/*
		 * Ideas:
		 * - throttle: handZ - torsoZ
		 */
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
