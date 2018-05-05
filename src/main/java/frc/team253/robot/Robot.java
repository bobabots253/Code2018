package frc.team253.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team253.robot.subsystems.Pneumatics;
import frc.team253.robot.subsystems.driveTrain;

public class Robot extends IterativeRobot {

    public static OI oi;
    public static driveTrain drivetrain;
    public static Pneumatics pneumatics;

    @Override
    public void robotInit() {
        RobotMap.init();
        drivetrain = new driveTrain();
        oi = new OI();
        pneumatics = new Pneumatics();

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
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
    }
}