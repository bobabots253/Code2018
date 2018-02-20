package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevatorLift extends Command {

	public ElevatorLift(){
		requires(Robot.elevator);
	}
	
	protected void execute(){
		double left = Robot.oi.xboxController.getTriggerAxis(GenericHID.Hand.kLeft);
		double right = Robot.oi.xboxController.getTriggerAxis(GenericHID.Hand.kRight);
		
		if(Math.abs(left - right) < 0.05){
			Robot.elevator.move(.2);
		} else {
			Robot.elevator.move(left - right*0.5);
		}
		
		if(Robot.oi.xboxController.getYButton()){
			Robot.driveTrain.getRightFront().setSelectedSensorPosition(0, 0, 0);
		}
		
		SmartDashboard.putNumber("Elevator Encoder", Robot.driveTrain.getRightFront().getSelectedSensorPosition(0) / 4096.0);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
