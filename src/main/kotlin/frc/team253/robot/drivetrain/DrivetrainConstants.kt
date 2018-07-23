package frc.team253.robot.drivetrain

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.SPI

object DrivetrainConstants{
    const val PWM_RightBack = 1
    const val PWM_RightFront = 2
    const val PWM_LeftFront = 3
    const val PWM_LeftBack = 4

    val PCM_Shifter_1 = 4
    val PCM_Shifter_2 = 5

    val MXP_NavX = SPI.Port.kMXP

    val joystickDeadband = 0.05
    val kHRobotVmax = 2686
    val kHVeloCharSlopeL = 257
    val kHVeloCharInterceptL = 1.280
    val kHVeloCharSlopeR = 246
    val kHVeloCharInterceptR = 1.081

    val kLRobotVmax = 2686
    val kLVeloCharSlopeL = 257
    val kLVeloCharInterceptL = 1.280
    val kLVeloCharSlopeR = 246
    val kLVeloCharInterceptR = 1.081
}