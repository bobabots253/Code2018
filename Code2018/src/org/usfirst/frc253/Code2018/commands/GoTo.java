package org.usfirst.frc253.Code2018.commands;

import java.util.ArrayList;

import org.usfirst.frc253.Code2018.Robot;
import org.usfirst.frc253.Code2018.profiles.MotionProfileData;
import org.usfirst.frc253.Code2018.profiles.MotionProfileRunner;

import com.ctre.phoenix.motion.SetValueMotionProfile;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class GoTo extends Command {
	
	boolean toggle = true;
	
	public GoTo(ArrayList<MotionProfileData> path, double ETA){
		requires(Robot.driveTrain);
		setTimeout(ETA);
		Robot.runner.setPath(path);
	}
	
	protected void execute(){
		Robot.runner.control();
		
		SetValueMotionProfile setOutput = Robot.runner.getSetValue();
		
		Robot.driveTrain.getLeftFront().set(ControlMode.MotionProfile, setOutput.value);
		Robot.driveTrain.getRightFront().set(ControlMode.MotionProfile, setOutput.value);
		
		if(toggle){
			Robot.runner.startMotionProfile();
			toggle = false;
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

}
