package frc.team253.robot.drivetrain.commands

import edu.wpi.first.wpilibj.command.InstantCommand
import frc.team253.robot.drivetrain.DrivetrainSubsystem

class shiftGear : InstantCommand() {
    init {
        this.requires(DrivetrainSubsystem)
        this.isInterruptible = false
    }

    override fun execute() {
        DrivetrainSubsystem.gear = when (DrivetrainSubsystem.gear) {
            DrivetrainSubsystem.GearState.HIGH -> {
                DrivetrainSubsystem.GearState.LOW
            }
            DrivetrainSubsystem.GearState.LOW -> DrivetrainSubsystem.GearState.HIGH
            DrivetrainSubsystem.GearState.NEUTRAL -> {
                println("Shifting from neutral!")
                DrivetrainSubsystem.GearState.HIGH
            }
        }
    }
}
