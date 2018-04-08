package frc.team253.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import frc.team253.robot.subsystems.driveTrain;

public class Robot extends IterativeRobot {

    public static OI oi;
    public static driveTrain drivetrain;

    @Override
    public void robotInit() {
        RobotMap.init();
        drivetrain = new driveTrain();
        oi = new OI();

    }

    @Override
    public void disabledInit() {
    }

    @Override
    public void autonomousInit() {
    }

    @Override
    public void teleopInit() {
    }

    @Override
    public void testInit() {
    }


    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopPeriodic() {
    }

    @Override
    public void testPeriodic() {
    }
}