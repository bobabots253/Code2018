
package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.profiles.TrajecLib;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
//command for scoring at the switch 
public class ScoreScale extends CommandGroup {
    public ScoreScale() {
    	addSequential(new SetElevator(TrajecLib.ScaleUp, 5));
		addSequential(new StraightDriveSlow(0.5));
		addSequential(new Release());
		addSequential(new DriveBackwards(1));
		addSequential(new elevatorDown(6));
    }
}
