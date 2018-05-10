package frc.team253.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team253.robot.Robot;

import static frc.team253.robot.Constants.kMaxTurnRadius;
import static frc.team253.robot.Constants.kWheelBaseWidthMeters;

public class drive extends Command {
    private double radius;
    private double r;
    private double turnDir;

    public drive() {
        requires(Robot.drivetrain);
    }

    protected void execute() {
        double throttle = Robot.oi.throttleValue();
        double wheel = Robot.oi.turnValue();

        //RADIUS CODE
        if(Math.abs(throttle) < 0.05){
            Robot.drivetrain.drive(-wheel,wheel);
        }else if(Math.abs(wheel)<0.05){
            Robot.drivetrain.drive(throttle,throttle);
        }else{
            //wheel = Math.pow(wheel, 1.0 / 3.0);
            radius = (kWheelBaseWidthMeters / 2) + (kMaxTurnRadius) * (1 - Math.abs(wheel));
            System.out.println("radius1 " + radius);

            turnDir = Math.copySign(1, radius);

            radius = Math.abs(radius);

            r = (radius - (kWheelBaseWidthMeters / 2)) /
                    (radius + (kWheelBaseWidthMeters / 2));

            double Vouter = (2 * throttle) / (1 / r);
            double Vinner = r * Vouter;

            if (Vouter > 1) {
                Vinner /= Vouter;
                Vouter /= Vouter;
            }

            if (turnDir > 0) {
                Robot.drivetrain.drive(Vouter, Vinner);
            } else {
                Robot.drivetrain.drive(Vinner, Vouter);
            }
            System.out.println(Vouter + "," + Vinner);
            System.out.println("throtle " + throttle);
            System.out.println("wheel " + wheel);
            System.out.println("radius2 " + radius);
            System.out.println(turnDir);
        }


        //DIFFERENTIAL CODE
        /*if (Math.abs(Robot.oi.throttleValue()) <= 0.05) {
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
        }*/
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
