package org.usfirst.frc253.Code2018.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class ChangeableSubsystem extends Subsystem{
    public void changeDefaultCommand(Command defCommand){
    	setDefaultCommand(defCommand);
    }
}
