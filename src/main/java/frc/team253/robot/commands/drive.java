package frc.team253.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team253.robot.Robot;
import frc.team253.robot.subsystems.limelight;
import frc.team253.robot.subsystems.limelight;

public class drive extends Command {
    private double left = 0, right = 0;
    double kP = -0.000001;

    public drive() {
        requires(Robot.drivetrain);
        requires(Robot.Limelight);
    }


    protected void execute() {

        SmartDashboard.putNumber("xOffset", Robot.Limelight.getxOffset());


        double steering = Robot.Limelight.getxOffset() / 50;

        SmartDashboard.putNumber("does math work?", steering);

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

            SmartDashboard.putNumber("left control", -steering);
            SmartDashboard.putNumber("right control", steering);

            Robot.drivetrain.drive(-steering, steering);
        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}
