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
		SmartDashboard.putNumber("KinectData data", table.getEntry("data").getDouble(0));
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
