package frc.team253.robot.subsystems;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;


public class limelight {
    NetworkTable table;
    double targetD;
    boolean hasTarget; //whether target is detected or tracked
    double xOffset; //horizontal offset from crosshair
    double yOffset;//vertical offset from crosshair
    double area; //target area(percentage)
    double skew;//rotation -90 to 0 degrees
    double LEDMode;
    double camMode;
    double pipeline;
    double snapshot;
    double angle;
    double Tdistance;

    public limelight(){
        table = NetworkTableInstance.getDefault().getTable("limelight");
    }

    public boolean isHasTarget() {
        targetD = table.getEntry("tv").getDouble(0);
        if(targetD == 0){
            hasTarget = false;
        } else if(targetD == 1){
            hasTarget = true;
        }
        return hasTarget;
    }

    public double getxOffset() {
        xOffset = table.getEntry("tx").getDouble(0);
        return xOffset;
    }

    public double getyOffset(){
        yOffset = table.getEntry("ty").getDouble(0);
        return yOffset;
    }

    public double getArea(){
        area = table.getEntry("ta").getDouble(0);
        return area;
    }

    public double getSkew(){
        skew = table.getEntry("ta").getDouble(0);
        return skew;
    }




}
