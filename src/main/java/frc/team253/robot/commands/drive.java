package frc.team253.robot.commands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team253.robot.Robot;
import frc.team253.robot.subsystems.limelight;


public class drive extends Command {
    private double left = 0, right = 0;
    double kPAim = -0.1;
    double kPDistance = -0.1;
    double min_aim_command = 0.05;


    public drive() {
        requires(Robot.drivetrain);
    }


    protected void execute() {

        SmartDashboard.putNumber("xOffset", Robot.Limelight.getxOffset());
        SmartDashboard.putNumber("yOffset", Robot.Limelight.getyOffset());





        if(!Robot.oi.xboxcontroller.getBButton()) {
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
        } else {
            double heading_error = -Robot.Limelight.getxOffset();
            double distance_error = -Robot.Limelight.getyOffset() /1.5;
            double steering_adjust = 0.0;

            SmartDashboard.putNumber("Steering Adjust", steering_adjust);
            if(Robot.Limelight.getxOffset() > 3.0){
                steering_adjust = (kPAim*heading_error - min_aim_command)/3;


            }else if(Robot.Limelight.getxOffset() < 3.0){
                steering_adjust = (kPAim*heading_error + min_aim_command)/3;
            }
            double distance_adjust = kPDistance * distance_error;
            left =(steering_adjust + distance_adjust)/1.5;
            right =(steering_adjust - distance_adjust)/1.5;

            Robot.drivetrain.drive(-left, right);
        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
