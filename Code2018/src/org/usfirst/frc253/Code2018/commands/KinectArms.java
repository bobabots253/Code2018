package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class KinectArms extends Command{
	public KinectArms(){
		requires(Robot.arms);
	}
	
	protected void execute(){
		double lHandX = Robot.table.getEntry("lHandX").getDouble(0);
		double rHandX = Robot.table.getEntry("rHandX").getDouble(0);
		
		double lElbowX = Robot.table.getEntry("lElbowX").getDouble(0);
		double rElbowX = Robot.table.getEntry("rElbowX").getDouble(0);
		//HOW GOD HELP ME I DON'T KNOW HOW TO WRITE CODE
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
