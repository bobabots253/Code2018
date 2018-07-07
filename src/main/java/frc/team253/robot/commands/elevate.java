package frc.team253.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import static frc.team253.robot.Robot.elevator;
import static frc.team253.robot.Robot.oi;

public class elevate extends Command {

    public elevate(){
        requires(elevator);
    }

    protected void execute(){
        double elevateAxis = oi.elevateValue(); //sets elevateAxis to joystick input

        /*if(Math.abs(elevateAxis) >= 0.4){
            elevator.elevatorControl.disable();
            elevator.elevate(elevateAxis);
        }else{
            elevator.elevatorControl.setSetpoint(DriveTrain.leftFront.getSelectedSensorPosition(0));
            elevator.elevatorControl.enable();
        }*/
        elevator.elevatorControl.disable();
        if(Math.abs(elevateAxis)>0.1){
            elevator.elevate(elevateAxis);
        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
