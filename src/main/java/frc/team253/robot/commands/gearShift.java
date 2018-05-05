package frc.team253.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team253.robot.Robot;

public class gearShift extends Command {

    boolean changeStatus = true;
    boolean toggle = true;

    public gearShift() {
        requires(Robot.pneumatics);

    }

    protected void initialize() {
    }

    protected void execute() {
        boolean isPressedTurnedOn = Robot.oi.xboxcontroller.getTriggerAxis(GenericHID.Hand.kLeft) > 0.1;

        if (isPressedTurnedOn && toggle) {
            toggle = false;
            changeStatus = !changeStatus;
        } else if (!isPressedTurnedOn) {
            toggle = true;
        }
        if (!changeStatus) {
            Robot.pneumatics.shiftForward();
        } else {
            Robot.pneumatics.shiftBackward();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
