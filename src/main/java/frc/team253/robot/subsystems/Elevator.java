package frc.team253.robot.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.team253.robot.ElevatorEncoderSource;
import frc.team253.robot.RobotMap;
import frc.team253.robot.commands.elevate;
import frc.team253.robot.subsystems.driveTrain;

public class Elevator extends Subsystem {

    private final Spark Elevator1 = RobotMap.Elevator1;
    private final Spark Elevator2 = RobotMap.Elevator2;

    private final SpeedControllerGroup ElevatorSparks = new SpeedControllerGroup(Elevator1,Elevator2);
    private ElevatorEncoderSource ElevatorEncoderSource = new ElevatorEncoderSource();
    public PIDController elevatorControl = new PIDController(0,0,0,ElevatorEncoderSource,ElevatorSparks);
    public Elevator() {

    }

    public void elevate(double speed){
        ElevatorSparks.set(speed);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new elevate());
    }

}
