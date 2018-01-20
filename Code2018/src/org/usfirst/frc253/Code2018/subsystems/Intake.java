package org.usfirst.frc253.Code2018.subsystems;

import org.usfirst.frc253.Code2018.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final SpeedController VictorSP1 = RobotMap.IntakeVictorSP1;
	private final SpeedController VictorSP2 = RobotMap.IntakeVictorSP2;
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    //giving VictorSP's values
    public void grab(){
    	VictorSP1.set(.5);
    	VictorSP2.set(-.5);
    }
    public void letGo(){
    	VictorSP1.set(-.5);
    	VictorSP2.set(.5);
    }
    public void stopGrab(){
    	VictorSP1.set(0);
    	VictorSP2.set(0);
    }
    
    
}

