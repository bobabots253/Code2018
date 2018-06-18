package frc.team253.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;

import static frc.team253.robot.Robot.*;

public class gearShift extends Command {

    private boolean changeStatus = true;
    private boolean toggle = true;

    public gearShift() {
        requires(pneumatics);

    }

    protected void initialize() {
    }

    protected void execute() {
        boolean isPressedTurnedOn = oi.xboxcontroller.getTriggerAxis(GenericHID.Hand.kLeft) > 0.1;

        if (isPressedTurnedOn && toggle) {
            toggle = false;
            changeStatus = !changeStatus;
        } else if (!isPressedTurnedOn) {
            toggle = true;
        }
        if (!changeStatus) {
            pneumatics.shiftForward();
        } else {
            pneumatics.shiftBackward();
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
