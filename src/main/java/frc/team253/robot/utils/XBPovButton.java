package frc.team253.robot.utils;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class XBPovButton extends JoystickButton {
    private GenericHID joystickNumber;
    private int xboxPOV;

    public XBPovButton(GenericHID joystick, int buttonNumber) {
        super(joystick, buttonNumber);

        joystickNumber = joystick;
        xboxPOV = buttonNumber;
    }

    public boolean get(){
        return joystickNumber.getPOV() == xboxPOV;
    }
}
