package frc.team253.robot.commands;

import frc.team253.robot.subsystems.driveTrain;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import frc.team253.robot.Robot;
import frc.team253.robot.subsystems.limelight;


public class trackCube extends Command {

    private boolean changeStatus = true;
    private boolean toggle = true;
    double kP = -0.1;
    double left =0;
    double right =0;
    public trackCube() {
        requires(Robot.Limelight);

    }

    protected void initialize() {
    }

    protected void execute() {

        double tx = Robot.Limelight.getxOffset();
        double steering = tx * kP;
        left+=steering;
        right -=steering;


        Robot.drivetrain.drive(left, right);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted(){
    }

}
