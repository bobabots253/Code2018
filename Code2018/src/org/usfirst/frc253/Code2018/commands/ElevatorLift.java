package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;

public class ElevatorLift extends Command {

	protected void execute(){
		double left = Robot.oi.xboxController.getTriggerAxis(GenericHID.Hand.kLeft);
		double right = Robot.oi.xboxController.getTriggerAxis(GenericHID.Hand.kRight);
		
		Robot.elevator.move(left - right);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
