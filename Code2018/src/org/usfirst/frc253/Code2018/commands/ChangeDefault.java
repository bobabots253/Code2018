package org.usfirst.frc253.Code2018.commands;

import org.usfirst.frc253.Code2018.Robot;
import org.usfirst.frc253.Code2018.subsystems.ChangeableSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ChangeDefault extends Command{

	ChangeableSubsystem subsystem;
	Command defCommand;
	
	public ChangeDefault(Subsystem subsystem, Command defCommand){
		requires(subsystem);
		this.defCommand = defCommand;
	}
	
	protected void execute(){
		subsystem.changeDefaultCommand(defCommand);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
