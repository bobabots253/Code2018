package org.usfirst.frc253.Code2018.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ScoreSwitch extends CommandGroup {
	public ScoreSwitch(Command toSwitch){
		addParallel(toSwitch);
		addSequential(new elevatorUp(1.5));
	}
}
