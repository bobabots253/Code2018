package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorHold extends Command{

	public ElevatorHold(double duration){
		requires(Robot.elevator);
		setTimeout(duration);
	}
	
	protected void execute(){
		Robot.elevator.move(0.225);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}
	
}
