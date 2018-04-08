package frc.team253.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;

public class OI {

    public XboxController xboxcontroller;

    public double throttleValue() {
        return xboxcontroller.getY(GenericHID.Hand.kLeft);
    }

    public double turnValue() {
        return xboxcontroller.getX(GenericHID.Hand.kRight);
    }
}
