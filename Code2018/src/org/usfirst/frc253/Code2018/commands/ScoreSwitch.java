package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.profiles.Constants;
import org.usfirst.frc253.Code2018.profiles.TrajecLib;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ScoreSwitch extends CommandGroup {
	public ScoreSwitch(Command toSwitch){
		addParallel(toSwitch);
		addSequential(new SetElevator(TrajecLib.SwitchUp));
		addSequential(new Release());
		
	}
}
