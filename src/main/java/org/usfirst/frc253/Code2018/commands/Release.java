package org.usfirst.frc253.Code2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Release extends CommandGroup{
	
	public Release(){
		addParallel(new Eject(1.1));
		addSequential(new Wait(0.5));
		addSequential(new SolenoidIntakeReverse(0.1));
	}

}
