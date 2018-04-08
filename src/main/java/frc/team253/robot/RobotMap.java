package frc.team253.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class RobotMap {

    public static TalonSRX driveTrainLeftBack,
            driveTrainLeftFront,
            driveTrainRightFront,
            driveTrainRightBack;


    public static void init() {

        driveTrainRightBack = new TalonSRX(1);
        driveTrainRightFront = new TalonSRX(2);
        driveTrainLeftFront = new TalonSRX(3);
        driveTrainLeftBack = new TalonSRX(4);

    }
}
