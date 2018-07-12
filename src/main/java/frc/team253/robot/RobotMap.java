package frc.team253.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;

public class RobotMap {

    public static TalonSRX driveTrainLeftBack,
            driveTrainLeftFront,
            driveTrainRightFront,
            driveTrainRightBack;

    public static Spark Elevator1, Elevator2;
    public static DoubleSolenoid solenoid1;

    public static Compressor compressorA;

    public static AHRS gyro;

    public static void init() {

        driveTrainRightBack = new TalonSRX(1);
        driveTrainRightFront = new TalonSRX(2);
        driveTrainLeftFront = new TalonSRX(3);
        driveTrainLeftBack = new TalonSRX(4);

        Elevator1 = new Spark(4);
        Elevator2 = new Spark (5);

        solenoid1 = new DoubleSolenoid(1, 4, 5);

        gyro = new AHRS(SPI.Port.kMXP);

    }
}
