package frc.team253.robot.drivetrain

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.FeedbackDevice
import com.ctre.phoenix.motorcontrol.NeutralMode
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced
import com.ctre.phoenix.motorcontrol.can.TalonSRX

import com.kauailabs.navx.frc.AHRS
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.GenericHID
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team253.robot.OI


object DrivetrainSubsystem : Subsystem() {

    override fun initDefaultCommand() {
        curvatureDrive(OI.xbox1.getY(GenericHID.Hand.kLeft),OI.xbox1.getX(GenericHID.Hand.kRight))
    }

    private val leftMotor1 = TalonSRX(DrivetrainConstants.PWM_LeftBack)
    private val leftMotor2 = TalonSRX(DrivetrainConstants.PWM_LeftFront)
    private val rightMotor1 = TalonSRX(DrivetrainConstants.PWM_RightFront)
    private val rightMotor2 = TalonSRX(DrivetrainConstants.PWM_RightBack)


    private val gyro = AHRS(DrivetrainConstants.MXP_NavX)

    private val shiftSolenoid = DoubleSolenoid(1,
            DrivetrainConstants.PCM_Shifter_1,
            DrivetrainConstants.PCM_Shifter_2)

    var gear = GearState.NEUTRAL
        set(inputState) {
            shiftSolenoid.set(inputState.solenoidState)
            field = inputState

        }

    fun resetEncoders() {
        leftMotor1.setSelectedSensorPosition(0, 0, 10)
        leftMotor2.setSelectedSensorPosition(0, 0, 10)
        rightMotor1.setSelectedSensorPosition(0, 0, 10)
    }
    init{
        leftMotor2.follow(leftMotor1)
        rightMotor2.follow(rightMotor1)

        leftMotor1.configPeakCurrentLimit(0, 10)
        leftMotor2.configPeakCurrentLimit(0, 10)
        rightMotor1.configPeakCurrentLimit(0, 10)
        rightMotor2.configPeakCurrentLimit(0, 10)

        leftMotor1.configContinuousCurrentLimit(45,10)
        leftMotor2.configContinuousCurrentLimit(45,10)
        rightMotor1.configContinuousCurrentLimit(45,10)
        rightMotor2.configContinuousCurrentLimit(45,10)

        leftMotor1.inverted = false
        leftMotor2.inverted = false
        rightMotor1.inverted = true
        rightMotor2.inverted = true

        leftMotor1.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature,1, 10)
        leftMotor2.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature,1, 10)
        rightMotor1.setStatusFramePeriod(StatusFrameEnhanced.Status_3_Quadrature,1, 10)

        leftMotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0 , 10)
        leftMotor2.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0 , 10)
        rightMotor1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0 , 10)

        leftMotor1.configVoltageCompSaturation(12.0,10)
        leftMotor2.configVoltageCompSaturation(12.0,10)
        rightMotor1.configVoltageCompSaturation(12.0,10)
        rightMotor2.configVoltageCompSaturation(12.0,10)

        leftMotor1.enableVoltageCompensation(true)
        leftMotor2.enableVoltageCompensation(true)
        rightMotor1.enableVoltageCompensation(true)
        rightMotor2.enableVoltageCompensation(true)

        leftMotor1.setSensorPhase(false)
        leftMotor2.setSensorPhase(false)
        rightMotor1.setSensorPhase(false)

        gear = GearState.LOW
        resetEncoders()
    }

    fun curvatureDrive(throttle : Double, turn : Double){

        leftMotor1.setNeutralMode(NeutralMode.Brake)
        leftMotor2.setNeutralMode(NeutralMode.Brake)
        rightMotor1.setNeutralMode(NeutralMode.Brake)
        rightMotor2.setNeutralMode(NeutralMode.Brake)

        var left : Double; var right : Double

        if(Math.abs(throttle) < DrivetrainConstants.joystickDeadband) {
            left = -turn
            right = turn
        } else {
            left = throttle+throttle*turn
            right = throttle-throttle*turn
        }

        when(gear){
            GearState.HIGH -> {
                left = processDriveChar(left,
                        DrivetrainConstants.kHRobotVmax,
                        DrivetrainConstants.kHVeloCharSlopeL,
                        DrivetrainConstants.kHVeloCharInterceptL)
                right = processDriveChar(right,
                        DrivetrainConstants.kHRobotVmax,
                        DrivetrainConstants.kHVeloCharSlopeR,
                        DrivetrainConstants.kHVeloCharInterceptR)
            }
            GearState.LOW -> {
                left = processDriveChar(left,
                        DrivetrainConstants.kLRobotVmax,
                        DrivetrainConstants.kLVeloCharSlopeL,
                        DrivetrainConstants.kLVeloCharInterceptL)
                right = processDriveChar(right,
                        DrivetrainConstants.kLRobotVmax,
                        DrivetrainConstants.kLVeloCharSlopeR,
                        DrivetrainConstants.kLVeloCharInterceptR)
            }
            else -> println("Shifted into neutral. Will not process characterizaton. ")
        }

        leftMotor1.set(ControlMode.PercentOutput, left)
        rightMotor1.set(ControlMode.PercentOutput, right)
    }

    fun processDriveChar(wantedspeed : Double, Vmax : Int, slope : Int, intercept : Double) : Double{
        return ((wantedspeed * Vmax / slope) + Math.copySign(intercept, wantedspeed)) / 12
    }

    enum class GearState(val solenoidState: DoubleSolenoid.Value) {
        HIGH(DoubleSolenoid.Value.kForward),
        LOW(DoubleSolenoid.Value.kReverse),
        NEUTRAL(DoubleSolenoid.Value.kOff)
    }

}