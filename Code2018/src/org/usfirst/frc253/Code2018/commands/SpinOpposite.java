package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinOpposite extends Command{

	public SpinOpposite(){
		requires(Robot.intake);
	}
	
	protected void execute(){
		Robot.intake.spinOpposite();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		Robot.intake.stop();
	}
	
	protected void interrupted(){
		Robot.intake.stop();
	}

}
