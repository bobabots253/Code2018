package frc.team253.robot

import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.command.Scheduler
import frc.team253.robot.drivetrain.DrivetrainSubsystem

class Robot : IterativeRobot(){

    init{
        OI
        DrivetrainSubsystem
    }

    override fun robotInit(){

    }

    override fun disabledInit() {

    }

    override fun autonomousInit() {

    }

    override fun teleopInit() {

    }

    override fun autonomousPeriodic() {
        Scheduler.getInstance().run()
    }

    override fun teleopPeriodic() {
        Scheduler.getInstance().run()
    }

}