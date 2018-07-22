package frc.team253.robot

import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.command.Scheduler

class Robot : IterativeRobot(){

    init{
        OI
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