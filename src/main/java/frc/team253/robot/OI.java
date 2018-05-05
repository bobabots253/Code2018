package frc.team253.robot;

import edu.wpi.first.wpilibj.XboxController;

import static edu.wpi.first.wpilibj.GenericHID.Hand;

public class OI {

    public XboxController xboxcontroller;

    public OI() {
        xboxcontroller = new XboxController(1);
    }

    public double throttleValue() {
        return xboxcontroller.getY(Hand.kLeft);
    }

    public double turnValue() {
        return xboxcontroller.getX(Hand.kRight);
    }
}
