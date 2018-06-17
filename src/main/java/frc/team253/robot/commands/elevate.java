package frc.team253.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team253.robot.subsystems.Elevator;

import static main.java.frc.team253.robot.Robot.elevator;
import static main.java.frc.team253.robot.Robot.oi;

public class elevate extends Command {

    public elevate(){
        requires(elevator);
    }

    protected void execute(){
        double elevateAxis = oi.elevateValue();

        if(elevateAxis >= 0.05){
            elevator.elevatorControl.disable();
            elevator.elevate(elevateAxis);
        }else{
            elevator.elevatorControl.enable();
        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
