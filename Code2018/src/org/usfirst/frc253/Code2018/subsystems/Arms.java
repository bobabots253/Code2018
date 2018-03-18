package org.usfirst.frc253.Code2018.subsystems;
import org.usfirst.frc253.Code2018.RobotMap;
import org.usfirst.frc253.Code2018.commands.ArmsControl;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Arms extends Subsystem{
	
	private final VictorSPX swingIntake1 = RobotMap.swingIntake1;
	private final Talon swingIntake2 = RobotMap.swingIntake2;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArmsControl());
    }
    
    public void swing(double speed){
    	swingIntake1.set(ControlMode.PercentOutput, speed);
    	swingIntake2.set(speed);
    }
    public void swingLeft(double speed){
    	swingIntake1.set(ControlMode.PercentOutput, speed);
    }
    public void swingRight(double speed){
    	swingIntake2.set(speed);
    }
    //giving VictorSP's values
    public void swingInT(){
    	swingIntake1.set(ControlMode.PercentOutput, .5);
    	swingIntake2.set(.5);
    }
    public void swingOutT(){
    	swingIntake1.set(ControlMode.PercentOutput, -.5);
    	swingIntake2.set(-.5);
    }
    public void swingIn(){
    	swingIntake1.set(ControlMode.PercentOutput, .5);
    //	swingIntake2.set(.5);
    }
    
    
    public void swingOut(){
    	//swingIntake1.set(ControlMode.PercentOutput,-.5);
    	swingIntake2.set(-.5);
    }
    public void swingInL(){
    	swingIntake1.set(ControlMode.PercentOutput, .5);
    	//swingIntake2.set(.5);
    }
    public void swingOutL(){
    	//swingIntake1.set(ControlMode.PercentOutput,-.5);
    	swingIntake2.set(-.5);
    }
    public void swingStop(){
    	swingIntake1.set(ControlMode.PercentOutput, 0.075);
    	swingIntake2.set(0.075);
    }
}
