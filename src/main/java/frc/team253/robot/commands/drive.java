package frc.team253.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team253.robot.Constants;
import frc.team253.robot.RobotMap;

import static frc.team253.robot.Constants.*;
import static frc.team253.robot.Robot.*;

public class drive extends Command {
    double kPAim = -0.1;
    double kPDistance = -0.1;
    double min_aim_command = 0.05;


    public drive() {
        requires(drivetrain);
    }


    protected void execute() {

        double throttle = oi.throttleValue(),
                wheel = oi.turnValue();

        SmartDashboard.putNumber("xOffset", Limelight.getxOffset());
        SmartDashboard.putNumber("yOffset", Limelight.getyOffset());

        //Vision when B button is held

        double right = 0;
        double left = 0;
        if(oi.xboxcontroller.getBButton()) {
            double heading_error = -Limelight.getxOffset();
            double distance_error = -Limelight.getyOffset() / 1.5;
            double steering_adjust = 0.0;

            SmartDashboard.putNumber("Steering Adjust", steering_adjust);
            if (Limelight.getxOffset() > 3.0) {
                steering_adjust = (kPAim * heading_error - min_aim_command) / 3;


            } else if (Limelight.getxOffset() < 3.0) {
                steering_adjust = (kPAim * heading_error + min_aim_command) / 3;
            }
            double distance_adjust = kPDistance * distance_error;
            left = -((steering_adjust + distance_adjust) / 1.5);
            right = (steering_adjust - distance_adjust) / 1.5;

        } else { //curvature driving
            if (Math.abs(throttle) < kDriveDeadband) { //quickturning if throttle stick is not moved past 5%
                left = -wheel;
                right = wheel;
            } else if (throttle > kDriveDeadband) { //positive drive values
                left =-throttle+throttle*wheel;
                right =-throttle-throttle*wheel;
            } else { //negative drive values
                left = throttle+throttle*wheel;
                right = throttle-throttle*wheel;
            }
        }

        //DRIVETRAIN CHARACTERIZATION NUMBER PROCESSING
        if (Math.abs(throttle) > kDriveDeadband || Math.abs(wheel) > kDriveDeadband || oi.xboxcontroller.getBButton()) {

            if (RobotMap.solenoid1.get() == DoubleSolenoid.Value.kForward) { //if solenoids are in forward position

                left = processDriveChar(left, Constants.kHRobotVmax, kHVeloCharSlopeL,kHVeloCharInterceptL);
                right = processDriveChar(right, Constants.kHRobotVmax, kHVeloCharSlopeR,kHVeloCharInterceptR);

            } else if (RobotMap.solenoid1.get() == DoubleSolenoid.Value.kReverse) { //if solenoids are in reverse position

                left = processDriveChar(left, kLRobotVmax, kLVeloCharSlopeL,kLVeloCharInterceptL);
                right = processDriveChar(right, kLRobotVmax, kLVeloCharSlopeR,kLVeloCharInterceptR);
            }

            drivetrain.drive(left, right);
        } else {
            drivetrain.drive(0, 0);
        }
    }
    protected double processDriveChar(double wantedSpeed, double Vmax, double slope, double intercept){

        return (((wantedSpeed*Vmax)
                / slope)
                + Math.copySign(intercept, wantedSpeed))
                / 12;
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
