package org.usfirst.frc253.Code2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GetCube extends CommandGroup{
	public GetCube(){
		addSequential(new TakeIn(4));
		addSequential(new SwingIn(2));
		addSequential(new Wait(2));
		addSequential(new SolenoidIntakeForward(0.1));
		addSequential(new SwingOut(2));
	}
}
