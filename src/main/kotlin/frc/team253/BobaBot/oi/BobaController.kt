package frc.team253.BobaBot.oi

import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj.buttons.JoystickButton
import frc.team253.BobaBot.oi.utils.JoystickPOV
import frc.team253.BobaBot.oi.utils.XBConstants

class BobaController(port: Int) : XboxController(port) {
    // Buttons
    val aButton = JoystickButton(this, XBConstants.Button.A.id)
    val bButton = JoystickButton(this, XBConstants.Button.B.id)
    val xButton = JoystickButton(this, XBConstants.Button.X.id)
    val yButton = JoystickButton(this, XBConstants.Button.Y.id)
    val lbButton = JoystickButton(this, XBConstants.Button.LB.id)
    val rbButton = JoystickButton(this, XBConstants.Button.RB.id)
    val startButton = JoystickButton(this, XBConstants.Button.START.id)
    val selectButton = JoystickButton(this, XBConstants.Button.SELECT.id)
    val leftStickButton = JoystickButton(this, XBConstants.Button.LEFT_STICK.id)
    val rightStickButton = JoystickButton(this, XBConstants.Button.RIGHT_STICK.id)

    // D-Pad Buttons
    val upDPad = JoystickPOV(this, XBConstants.DPad.UP)
    val upRightDPad = JoystickPOV(this, XBConstants.DPad.UP_RIGHT)
    val rightDPad = JoystickPOV(this, XBConstants.DPad.RIGHT)
    val downRightDPad = JoystickPOV(this, XBConstants.DPad.DOWN_RIGHT)
    val downDPad = JoystickPOV(this, XBConstants.DPad.DOWN)
    val downLeftDPad = JoystickPOV(this, XBConstants.DPad.DOWN_LEFT)
    val leftDPad = JoystickPOV(this, XBConstants.DPad.LEFT)
    val upLeftDPad = JoystickPOV(this, XBConstants.DPad.UP_LEFT)

}