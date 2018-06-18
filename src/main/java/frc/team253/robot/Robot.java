package main.java.frc.team253.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team253.robot.OI;

import frc.team253.robot.RobotMap;
import frc.team253.robot.subsystems.Elevator;
import frc.team253.robot.subsystems.Pneumatics;
import frc.team253.robot.subsystems.driveTrain;
import frc.team253.robot.subsystems.limelight;

public class Robot extends IterativeRobot {

    public static OI oi;
    public static driveTrain drivetrain;
    public static Pneumatics pneumatics;
    public static limelight Limelight;
    public static Elevator elevator;



    @Override
    public void robotInit() {
        RobotMap.init();
        drivetrain = new driveTrain();
        elevator = new Elevator();
        pneumatics = new Pneumatics();
        Limelight = new limelight();
        oi = new OI();
        //Important: OI initialization has to come after all the subsystem declarations

        drivetrain.resetEncoders();
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
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);

        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopPeriodic() {
        //NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);

        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
    }
}