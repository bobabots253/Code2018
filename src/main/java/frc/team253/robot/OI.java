package frc.team253.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team253.robot.pathing.pathFollow;
import frc.team253.robot.utils.RunCommand;
import frc.team253.robot.utils.XBPovButton;

import static edu.wpi.first.wpilibj.GenericHID.Hand;
import static frc.team253.robot.Robot.elevator;
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
            dpadUP,
            dpadUP_RIGHT,
            dpadRIGHT,
            dpadDOWN_RIGHT,
            dpadDOWN,
            dpadDOWN_LEFT,
            dpadLEFT,
            dpadUP_LEFT;



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

        dpadUP = new XBPovButton(xboxcontroller, UP);
        dpadUP_RIGHT = new XBPovButton(xboxcontroller,UP_RIGHT);
        dpadRIGHT = new XBPovButton(xboxcontroller,RIGHT);
        dpadDOWN_RIGHT = new XBPovButton(xboxcontroller,DOWN_RIGHT);
        dpadDOWN = new XBPovButton(xboxcontroller,DOWN);
        dpadDOWN_LEFT = new XBPovButton(xboxcontroller,DOWN_LEFT);
        dpadLEFT = new XBPovButton(xboxcontroller,LEFT);
        dpadUP_LEFT = new XBPovButton(xboxcontroller,UP_LEFT);

        dpadLEFT.whileHeld(new pathFollow("Straight15ft"));

        dpadUP.whenPressed(new RunCommand(()->{
            elevator.elevatorControl.setSetpoint(0);
        }));

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
