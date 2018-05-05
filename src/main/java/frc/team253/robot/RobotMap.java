package frc.team253.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class RobotMap {

    public static TalonSRX driveTrainLeftBack,
            driveTrainLeftFront,
            driveTrainRightFront,
            driveTrainRightBack;

    public static DoubleSolenoid solenoid1;

    public static Compressor compressorA;

    public static void init() {

        driveTrainRightBack = new TalonSRX(1);
        driveTrainRightFront = new TalonSRX(2);
        driveTrainLeftFront = new TalonSRX(3);
        driveTrainLeftBack = new TalonSRX(4);

        solenoid1 = new DoubleSolenoid(1, 4, 5);



    }
}
