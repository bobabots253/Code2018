package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SwingIn extends Command{

	public SwingIn(double time){
		requires(Robot.arms);
		setTimeout(time);
	}
	
	protected void execute(){
		Robot.arms.swing(.5);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}
	
	protected void end(){
		Robot.arms.swing(0);
	}
	
	protected void interrupted(){
		Robot.arms.swing(0);
	}
	
}
