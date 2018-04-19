package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeControl extends Command{

	public IntakeControl(){
		requires(Robot.intake);
	}
	
	protected void execute(){
		boolean isPressedTurnedOn = Robot.oi.xboxController.getTriggerAxis(Hand.kRight) > 0.1;
		
		if(isPressedTurnedOn) {
			Robot.intake.intake();
		} else {
			Robot.intake.stop();
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
