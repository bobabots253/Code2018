package frc.team253.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team253.robot.Constants;
import frc.team253.robot.Robot;
import frc.team253.robot.RobotMap;

public class drive extends Command {
    private double left, right;

    public drive() {
        requires(Robot.drivetrain);
    }

    protected void execute() {

        if (Math.abs(Robot.oi.throttleValue()) <= 0.05) {
            left = -Robot.oi.turnValue();
            right = Robot.oi.turnValue();
        } else if (Robot.oi.xboxcontroller.getTriggerAxis(GenericHID.Hand.kLeft) > 0.06125) {
            left = -Robot.oi.throttleValue() + (Robot.oi.throttleValue() * Robot.oi.turnValue());
            right = -Robot.oi.throttleValue() - (Robot.oi.throttleValue() * Robot.oi.turnValue());
        } else {
            left = Robot.oi.throttleValue() + (Robot.oi.throttleValue() * Robot.oi.turnValue());
            right = Robot.oi.throttleValue() - (Robot.oi.throttleValue() * Robot.oi.turnValue());
        }

        left = Math.copySign(Math.pow(left, 2), left);
        right = Math.copySign(Math.pow(right, 2), right);

        if (Math.abs(Robot.oi.throttleValue()) <= 0.05) {
            if (RobotMap.solenoid1.get() == DoubleSolenoid.Value.kForward) { //if solenoids are in forward position

                left = (((left * Constants.kHRobotVmax)  //left value * max velocity (target velo in encoder units)
                        / Constants.kHVeloCharSlopeL) //divided by slope of drivetrain characterization line
                        + Math.copySign(Constants.kHVeloCharInterceptL, left)) //add minimum velocity to overcome friction
                        / 12; // convert to volts

                right = (((right * Constants.kHRobotVmax)
                        / Constants.kHVeloCharSlopeR) +
                        Math.copySign(Constants.kHVeloCharInterceptR, right))
                        / 12;

            } else if (RobotMap.solenoid1.get() == DoubleSolenoid.Value.kReverse) {
                left = (((left * Constants.kLRobotVmax)
                        / Constants.kLVeloCharSlopeL)
                        + Math.copySign(Constants.kLVeloCharInterceptL, left))
                        / 12;
                right = (((right * Constants.kLRobotVmax)
                        / Constants.kLVeloCharSlopeR)
                        + Math.copySign(Constants.kLVeloCharInterceptR, right))
                        / 12;
            }

            Robot.drivetrain.drive(left, right);
        } else {
            Robot.drivetrain.drive(0, 0);
        }


    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
