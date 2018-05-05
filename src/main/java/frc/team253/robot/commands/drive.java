package frc.team253.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team253.robot.Robot;

public class drive extends Command {
    double left = 0, right = 0;

    public drive() {
        requires(Robot.drivetrain);
    }

    protected void execute() {

        if (Math.abs(Robot.oi.throttleValue()) <= 0.06125) {
            left = -Robot.oi.turnValue();
            right = Robot.oi.turnValue();
        } else if (Robot.oi.xboxcontroller.getTriggerAxis(GenericHID.Hand.kLeft) > 0.06125) {
            left = -Robot.oi.throttleValue() + Robot.oi.throttleValue() * Robot.oi.turnValue();
            right = -Robot.oi.throttleValue() - Robot.oi.throttleValue() * Robot.oi.turnValue();
        } else {
            left = Robot.oi.throttleValue() + Robot.oi.throttleValue() * Robot.oi.turnValue();
            right = Robot.oi.throttleValue() - Robot.oi.throttleValue() * Robot.oi.turnValue();
        }

        Robot.drivetrain.drive(left, right);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
