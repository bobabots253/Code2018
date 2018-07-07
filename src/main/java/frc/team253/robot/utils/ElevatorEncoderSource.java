package frc.team253.robot.utils;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import frc.team253.robot.subsystems.DriveTrain;

public class ElevatorEncoderSource implements PIDSource {
    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {

    }

    @Override
    public PIDSourceType getPIDSourceType() {
        return null;
    }

    @Override
    public double pidGet() {
        return DriveTrain.leftFront.getSelectedSensorPosition(0);
    }
}
