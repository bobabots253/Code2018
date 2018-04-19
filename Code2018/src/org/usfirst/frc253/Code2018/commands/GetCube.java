package org.usfirst.frc253.Code2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GetCube extends CommandGroup{
	public GetCube(){
		addSequential(new SolenoidIntakeForward(0.1));
	}
}
