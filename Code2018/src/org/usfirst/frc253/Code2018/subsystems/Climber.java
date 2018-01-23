package org.usfirst.frc253.Code2018.subsystems;

import org.usfirst.frc253.Code2018.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//pulling spark1 from robotMap
	private final Spark ClimberSpark = RobotMap.Spark1;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    //methods that give the sparks a speed value
    public void up(){
    	ClimberSpark.set(.5);
    }
    public void down(){
    	ClimberSpark.set(-.5);
    }
    public void stop(){
    	ClimberSpark.set(0);
    }
}

