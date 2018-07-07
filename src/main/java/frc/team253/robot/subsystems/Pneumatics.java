package frc.team253.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team253.robot.RobotMap;
import frc.team253.robot.commands.gearShift;

public class Pneumatics extends Subsystem {
    private static Pneumatics instance = null;

    private final DoubleSolenoid shiftSolenoid = RobotMap.solenoid1;
    private final Compressor compressor = RobotMap.compressorA;

    private Pneumatics(){}

    public void initDefaultCommand() {
        setDefaultCommand(new gearShift());
    }

    public void compressStart() {
        compressor.setClosedLoopControl(true);
    }

    public void compressStop() {
        compressor.setClosedLoopControl(false);
    }

    public void shiftForward() {
        shiftSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void shiftBackward() {
        shiftSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void shiftOff() {
        shiftSolenoid.set(DoubleSolenoid.Value.kOff);
    }

    public static Pneumatics getInstance()
    {
        if (instance == null)
            instance = new Pneumatics();

        return instance;
    }
}
