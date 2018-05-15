package frc.team253.robot.commands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team253.robot.Robot;

public class vision extends Command {
    private double ledMode = 0;
    private boolean toggle;
    private boolean changeStatus;

    public vision(){
        requires(Robot.Limelight);
    }

    protected void execute(){


        boolean isPressedTurnedOn = Robot.oi.xboxcontroller.getTriggerAxis(GenericHID.Hand.kRight) > 0.1;

        if (isPressedTurnedOn && toggle) {
            toggle = false;
            changeStatus = !changeStatus;
        } else if (!isPressedTurnedOn) {
            toggle = true;
        }
        if (!changeStatus) {
            Robot.Limelight.setLEDMode(1);
        } else {
            Robot.Limelight.setLEDMode(0);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
