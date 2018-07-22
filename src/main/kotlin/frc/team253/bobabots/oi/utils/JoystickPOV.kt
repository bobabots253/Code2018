package frc.team253.bobabots.oi.utils

import edu.wpi.first.wpilibj.GenericHID
import edu.wpi.first.wpilibj.buttons.JoystickButton

class JoystickPOV(private val joystick: GenericHID, private val dPadButton: XBConstants.DPad) :
        JoystickButton(joystick, dPadButton.id) {
    // Get method should return whether the D-Pad axis is at the specified angle, effectively making a button.
    override fun get(): Boolean = joystick.pov == dPadButton.id
}