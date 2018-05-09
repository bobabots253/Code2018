package frc.team253.robot;

public class Constants {

    /**
     * which Talon on CANBus
     */
    public static final int kTalonID = 0;

    /**
     * How many sensor units per rotation. Using CTRE Magnetic Encoder.
     *
     * @link https://github.com/CrossTheRoadElec/Phoenix-Documentation#what-are-the-units-of-my-sensor
     */
    public static final double kSensorUnitsPerRotation = 4096;

    /**
     * Which PID slot to pull gains from. Starting 2018, you can choose from
     * 0,1,2 or 3. Only the first two (0,1) are visible in web-based
     * configuration.
     */
    public static final int kSlotIdx = 0;

    /**
     * Talon SRX/ Victor SPX will supported multiple (cascaded) PID loops. For
     * now we just want the primary one.
     */
    public static final int kPIDLoopIdx = 0;
    /**
     * set to zero to skip waiting for confirmation, set to nonzero to wait and
     * report to DS if action fails.
     */
    public static final int kTimeoutMs = 10;

    /**
     * Base trajectory period to add to each individual trajectory point's
     * unique duration. This can be set to any value within [0,255]ms.
     */
    public static final int kBaseTrajPeriodMs = 0;

    /**
     * Motor deadband, set to 4%.
     */
    public static final double kNeutralDeadband = 0.04;

    public static final double
            kWheelBaseWidthMeters = 0.59817,
            kWheelBaseWidthFeet = 1.9625,
            kWheelDiameterFeet = 0.5,
            kWheelDiameterMeters = 0.1524,
            kDriveTrainMaxVelMetersPSec = 5.7912,
            kElevatorMaxVelMetersPSec = 0.9144,
            kElevatorSprocketDiameterMeters = 0.0381,
            kGround = 0,
            kSwitchHeightFeet = 2.104,
            kScaleHeightFeet = 5.542,
            kPortalHeightFeet = 2.25,
            kSwitchHeightMeters = 0.41,
            kScaleHeightMeters = 1.1,
            kPortalHeightMeters = 0.6858,
            kTimeStepGlobal = 0.01;

    public static final double kHRobotVmax = 2686,
            kHVeloCharSlopeL = 257,
            kHVeloCharInterceptL = 1.280,
            kHVeloCharSlopeR = 246,
            kHVeloCharInterceptR = 1.081,

    public static final double kLRobotVmax = 2686,
            kLVeloCharSlopeL = 257,
            kLVeloCharInterceptL = 1.280,
            kLVeloCharSlopeR = 246,
            kLVeloCharInterceptR = 1.081;

    public static final double kMaxTurnRadius = 3.048;
}

