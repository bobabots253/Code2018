package org.usfirst.frc253.Code2018.subsystems;

import org.usfirst.frc253.Code2018.RobotMap;
import org.usfirst.frc253.Code2018.commands.IntakeControl;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
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

	private final VictorSPX spinIntake1 = RobotMap.spinIntake1;
	private final VictorSPX spinIntake2 = RobotMap.spinIntake2;
	private final VictorSP insideIntake1 = RobotMap.insideIntake1;
	private final VictorSP insideIntake2 = RobotMap.insideIntake2;
	private final DoubleSolenoid solenoidIntake = RobotMap.pneumaticsDoubleSolenoid2;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new IntakeControl());
    }
    //giving VictorSP's values

       
    public void intake(){
    	insideIntake1.set(0.45);
    	insideIntake2.set(-0.75);
    	spinIntake1.set(ControlMode.PercentOutput,- .75);
    	spinIntake2.set(ControlMode.PercentOutput, .75);
    }
    public void spinRight(){
    	insideIntake2.set(-0.25);
    }
    public void intakehalf(){
    	insideIntake1.set(0.1);
    	insideIntake2.set(-0.1);
    //	spinIntake1.set(ControlMode.PercentOutput, .75);
    //	spinIntake2.set(ControlMode.PercentOutput, .75);
    }
    public void hold(){
    	insideIntake1.set(0.1);
    	insideIntake2.set(-0.1);
    }
    public void eject(){
    	insideIntake1.set(-1);
    	insideIntake2.set(1);
    	spinIntake1.set(ControlMode.PercentOutput, 1);
    	spinIntake2.set(ControlMode.PercentOutput, -1);
    }
    public void ejectonly(){
    	insideIntake1.set(-0.75);
    	insideIntake2.set(0.75);
    //	spinIntake1.set(ControlMode.PercentOutput, -.75);
    	//spinIntake2.set(ControlMode.PercentOutput, -.75);
    }
    public void ejecthalf(){
    	insideIntake1.set(-0.5);
    	insideIntake2.set(0.5);
    //	spinIntake1.set(ControlMode.PercentOutput, -.75);
    	//spinIntake2.set(ControlMode.PercentOutput, -.75);
    }
    public void stop(){
    	insideIntake1.set(0);
    	insideIntake2.set(0);
    	spinIntake1.set(ControlMode.PercentOutput, 0);
    	spinIntake2.set(ControlMode.PercentOutput, 0);
    }
    public void solenoidIntakeForward(){
    	solenoidIntake.set(DoubleSolenoid.Value.kForward);
    }
    public void solenoidIntakeReverse(){
    	solenoidIntake.set(DoubleSolenoid.Value.kReverse);
    }
    public void solenoidIntakeOff(){
    	solenoidIntake.set(DoubleSolenoid.Value.kOff);
    }
}

