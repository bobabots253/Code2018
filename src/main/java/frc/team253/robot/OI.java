package frc.team253.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team253.robot.utils.XBPovButton;

import static edu.wpi.first.wpilibj.GenericHID.Hand;
import static frc.team253.robot.utils.Constants.POVConstants.*;

public class OI {

    public XboxController xboxcontroller;
    public JoystickButton ButtonA;
    public JoystickButton ButtonB;
    public JoystickButton ButtonX;
    public JoystickButton ButtonY;
    public JoystickButton ButtonRB;
    public JoystickButton ButtonLB;
    public JoystickButton ButtonRT;
    public JoystickButton ButtonLT;
    public Joystick elevatorStick;

    public JoystickButton
            povUP,
            povUP_RIGHT,
            povRIGHT,
            povDOWN_RIGHT,
            povDOWN,
            povDOWN_LEFT,
            povLEFT,
            povUP_LEFT;



    public OI() {
        elevatorStick = new Joystick(2);
        xboxcontroller = new XboxController(1);
        ButtonA = new JoystickButton(xboxcontroller, 1);
        ButtonB = new JoystickButton(xboxcontroller, 2);
        ButtonX = new JoystickButton(xboxcontroller, 3);
        ButtonY = new JoystickButton(xboxcontroller, 4);
        ButtonRB = new JoystickButton(xboxcontroller, 6);
        ButtonLB = new JoystickButton(xboxcontroller, 5);
        ButtonRT = new JoystickButton(xboxcontroller, 7);
        ButtonLT = new JoystickButton(xboxcontroller, 8);

        povUP = new XBPovButton(xboxcontroller, UP);
        povUP_RIGHT = new XBPovButton(xboxcontroller,UP_RIGHT);
        povRIGHT = new XBPovButton(xboxcontroller,RIGHT);
        povDOWN_RIGHT = new XBPovButton(xboxcontroller,DOWN_RIGHT);
        povDOWN = new XBPovButton(xboxcontroller,DOWN);
        povDOWN_LEFT = new XBPovButton(xboxcontroller,DOWN_LEFT);
        povLEFT = new XBPovButton(xboxcontroller,LEFT);
        povUP_LEFT = new XBPovButton(xboxcontroller,UP_LEFT);

    }

    public double throttleValue() {
        return xboxcontroller.getY(Hand.kLeft);
    }

    public double turnValue() {
        return xboxcontroller.getX(Hand.kRight);
    }

    public double elevateValue(){
        return elevatorStick.getY();
    }
}
