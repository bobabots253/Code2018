package frc.team253.robot.drivetrain.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team253.robot.drivetrain.DrivetrainSubsystem

class curvatureDrive(var throttle : Double, var turn : Double) : Command() {

    init{
        this.requires(frc.team253.robot.drivetrain.DrivetrainSubsystem)
        this.isInterruptible = true
    }

    override fun execute(){
        DrivetrainSubsystem.curvatureDrive(throttle, turn)
    }


    override fun isFinished(): Boolean {
        return false
    }
}