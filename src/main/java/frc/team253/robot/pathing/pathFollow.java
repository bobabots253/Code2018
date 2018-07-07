package frc.team253.robot.pathing;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team253.robot.Robot;
import frc.team253.robot.RobotMap;
import frc.team253.robot.commands.drive;
import frc.team253.robot.subsystems.DriveTrain;
import frc.team253.robot.utils.Constants;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

import java.io.File;


import static frc.team253.robot.Robot.drivetrain;

public class pathFollow extends Command {
    private final AHRS gyro = RobotMap.gyro;

    private double kP = 0, kI = 0, kD = 0, kV = 1/4.1861967305, kA = 0;
    Trajectory trajecLeft, trajecRight;
    EncoderFollower followerLeft, followerRight;

    public pathFollow(String pathName){
        SmartDashboard.putNumber("P gain",kP);
        SmartDashboard.putNumber("I gain",kI);
        SmartDashboard.putNumber("D gain",kD);

        gyro.reset();

        requires(drivetrain);
        Trajectory trajectory = Pathfinder.readFromCSV(new File("/home/lvuser/profiles/"+pathName));

        TankModifier modifier = new TankModifier(trajectory);
        modifier.modify(Constants.kWheelBaseWidthMeters);
        trajecLeft = modifier.getLeftTrajectory();
        trajecRight = modifier.getRightTrajectory();

        followerLeft = new EncoderFollower(trajecLeft);
        followerRight = new EncoderFollower(trajecRight);

        followerLeft.configureEncoder(DriveTrain.leftBack.getSelectedSensorPosition(0),
                3072, Constants.kWheelDiameterMeters);
        followerLeft.configureEncoder(DriveTrain.rightFront.getSelectedSensorPosition(0),
                3072, Constants.kWheelDiameterMeters);

        followerLeft.configurePIDVA(kP,kI,kD,kV,kA);
        followerRight.configurePIDVA(kP,kI,kD,kV,kA);
    }

    protected void execute() {
        kP = SmartDashboard.getNumber("P gain", kP);
        kI = SmartDashboard.getNumber("I gain", kI);
        kD = SmartDashboard.getNumber("D gain", kD);

        double left = followerLeft.calculate(Robot.drivetrain.leftBack.getSelectedSensorPosition(0));
        double right = followerLeft.calculate(Robot.drivetrain.leftBack.getSelectedSensorPosition(0));

        double gyroHeading = gyro.getYaw();
        double desiredHeading = Pathfinder.r2d(followerLeft.getHeading());
        double angleDifference = Pathfinder.boundHalfDegrees(desiredHeading - gyroHeading);
        double turn = 0.8 * (-1.0/80.0) * angleDifference;

        double leftspeed = left+turn;
        double rightspeed = right+turn;

        //leftspeed = drive.processDriveChar(leftspeed,Constants.kLRobotVmax,Constants.kLVeloCharSlopeL,Constants.kLVeloCharInterceptL);
        //rightspeed = drive.processDriveChar(rightspeed,Constants.kLRobotVmax,Constants.kLVeloCharSlopeR,Constants.kLVeloCharInterceptR);

        Robot.drivetrain.drive(leftspeed, rightspeed);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}

