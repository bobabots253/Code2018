@file:Suppress("unused")

package frc.team253.robot

import frc.team253.bobabots.oi.BobaController
import frc.team253.robot.drivetrain.commands.shiftGear

object OI {
    val xbox1 = BobaController(0)

    init{
        xbox1.rbButton.whenPressed(shiftGear())
    }
}