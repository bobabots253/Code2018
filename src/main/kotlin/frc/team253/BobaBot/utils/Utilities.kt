package frc.team253.BobaBot.utils

import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.InstantCommand

inline fun commandify(crossinline method: () -> Unit): Command = object : InstantCommand() {
    override fun execute() = method()
}