package org.usfirst.frc253.Code2018.profiles;

import java.util.HashMap;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;

public class TrajecLib {
	/****************************
	 * Drive Train Trajectories *
	 ****************************/
	public static Waypoint[] Straight15ftPoints = new Waypoint[]{
			new Waypoint(0, 0, 0),
			new Waypoint(4.572, 0, 0)
	};
	public static Trajectory.Config Straight15ftConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.01, 4, 2, 15);
	public static Trajectory Straight15ft = Pathfinder.generate(Straight15ftPoints, Straight15ftConfig);

	public static Waypoint[] RtoRSwitchPoints = new Waypoint[]{
			new Waypoint(.466344, 1.194816, 0),
			new Waypoint(3.4643480343, 2.0165480343, Pathfinder.d2r(45))
	};
	public static Trajectory.Config RtoRSwitchConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.01, 4, 2, 15);
	public static Trajectory RtoRSwitch = Pathfinder.generate(RtoRSwitchPoints, RtoRSwitchConfig);

	public static Waypoint[] RtoRScalePoints = new Waypoint[]{
			new Waypoint(.466344, 1.194816, 0),
			new Waypoint(7.755992, 1.264792, Pathfinder.d2r(45))
	};
	public static Trajectory.Config RtoRScaleConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.01, 5, 2.5, 15);
	public static Trajectory RtoRScale = Pathfinder.generate(RtoRScalePoints, RtoRScaleConfig);

	public static Waypoint[] RtoRScaleAltPoints = new Waypoint[]{
			new Waypoint(.466344, 1.194816, 0),
			new Waypoint(7.995992, 2.264792, Pathfinder.d2r(45))
	};
	public static Trajectory.Config RtoRScaleAltConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.01, 4, 2, 15);
	public static Trajectory RtoRScaleAlt = Pathfinder.generate(RtoRScaleAltPoints, RtoRScaleAltConfig);

	public static Waypoint[] CtoRSwitchPoints = new Waypoint[]{
			new Waypoint(.466344, 3.989832, 0),
			new Waypoint(3.315056, 2.38224, 0)
	};
	public static Trajectory.Config CtoRSwitchConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.01, 4, 2, 15);
	public static Trajectory CtoRSwitch = Pathfinder.generate(CtoRSwitchPoints, CtoRSwitchConfig);

	public static Waypoint[] CtoLSwitchPoints = new Waypoint[]{
			new Waypoint(.466344, 3.989832, 0),
			new Waypoint(3.315056, 5.81688, 0)
	};
	public static Trajectory.Config CtoLSwitchConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.01, 4, 2, 15);
	public static Trajectory CtoLSwitch = Pathfinder.generate(CtoLSwitchPoints, CtoLSwitchConfig);

	/*************************
	 * Elevator Trajectories *
	 *************************/
	public static Waypoint[] SwitchHeightPoints = new Waypoint[]{
			new Waypoint(0, 0, 0),
			new Waypoint(Constants.kSwitchHeightMeters, 0, 0)
	};
	public static Trajectory.Config SwitchHeightConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.01, 0.775, 0.3875, 2.90625);
	public static Trajectory SwitchHeight = Pathfinder.generate(SwitchHeightPoints, SwitchHeightConfig);
	
	public static Waypoint[] ScaleHeightPoints = new Waypoint[]{
			new Waypoint(0, 0, 0),
			new Waypoint(Constants.kScaleHeightMeters, 0, 0)
	};
	public static Trajectory.Config ScaleHeightConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.01, 0.775, 0.3875, 2.90625);
	public static Trajectory ScaleHeight = Pathfinder.generate(ScaleHeightPoints, ScaleHeightConfig);
	
	public static Waypoint[] PortalHeightPoints = new Waypoint[]{
			new Waypoint(0, 0, 0),
			new Waypoint(Constants.kPortalHeightMeters, 0, 0)
	};
	public static Trajectory.Config PortalHeightConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.01, 0.775, 0.3875, 2.90625);
	public static Trajectory PortalHeight = Pathfinder.generate(PortalHeightPoints, PortalHeightConfig);
}
