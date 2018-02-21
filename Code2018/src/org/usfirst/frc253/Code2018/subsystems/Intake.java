package org.usfirst.frc253.Code2018.subsystems;

import org.usfirst.frc253.Code2018.RobotMap;
import org.usfirst.frc253.Code2018.commands.IntakeControl;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final VictorSPX swingIntake1 = RobotMap.swingIntake1;
	private final Talon swingIntake2 = RobotMap.swingIntake2;
	private final VictorSPX spinIntake1 = RobotMap.spinIntake1;
	private final VictorSPX spinIntake2 = RobotMap.spinIntake2;
	private final VictorSP insideIntake1 = RobotMap.insideIntake1;
	private final VictorSP insideIntake2 = RobotMap.insideIntake2;
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new IntakeControl());
    }
    //giving VictorSP's values
    public void swingIn(){
    	swingIntake1.set(ControlMode.PercentOutput, .5);
    	swingIntake2.set(.5);
    }
    public void swingOut(){
    	swingIntake1.set(ControlMode.PercentOutput,-.5);
    	swingIntake2.set(-.5);
    }
    public void swingStop(){
    	swingIntake1.set(ControlMode.PercentOutput, 0);
    	swingIntake2.set(0);
    }    
    public void intake(){
    	insideIntake1.set(1);
    	insideIntake2.set(-1);
    	spinIntake1.set(ControlMode.PercentOutput, .75);
    	spinIntake2.set(ControlMode.PercentOutput, -.75);
    }
    public void eject(){
    	insideIntake1.set(-1);
    	insideIntake2.set(1);
    	spinIntake1.set(ControlMode.PercentOutput, -.75);
    	spinIntake2.set(ControlMode.PercentOutput, .75);
    }
    public void stop(){
    	insideIntake1.set(0);
    	insideIntake2.set(0);
    	spinIntake1.set(ControlMode.PercentOutput, 0);
    	spinIntake2.set(ControlMode.PercentOutput, 0);
    }
}

