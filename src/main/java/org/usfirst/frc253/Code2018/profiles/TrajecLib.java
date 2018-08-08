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
	public static Trajectory.Config Straight15ftConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, Constants.kTimeStepGlobal, 4, 2, 15);
	public static Trajectory Straight15ft = Pathfinder.generate(Straight15ftPoints, Straight15ftConfig);

	public static Waypoint[] RtoRSwitchPoints = new Waypoint[]{
			new Waypoint(.466344, 1.194816, 0),
			new Waypoint(3.643480343, 2.0165480343, Pathfinder.d2r(45))
	};
	public static Trajectory.Config RtoRSwitchConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, Constants.kTimeStepGlobal, 4, 2, 15);
	public static Trajectory RtoRSwitch = Pathfinder.generate(RtoRSwitchPoints, RtoRSwitchConfig);

	public static Waypoint[] RtoRScalePoints = new Waypoint[]{
			new Waypoint(.466344, 1.194816, 0),
			new Waypoint(7.755992, 1.264792, Pathfinder.d2r(45))
	};
	public static Trajectory.Config RtoRScaleConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, Constants.kTimeStepGlobal, 5, 2.5, 15);
	public static Trajectory RtoRScale = Pathfinder.generate(RtoRScalePoints, RtoRScaleConfig);

	public static Waypoint[] CtoRSwitchPoints = new Waypoint[]{
			new Waypoint(.466344, 3.989832, 0),
			new Waypoint(3.515056, 2.38224, 0)
	};
	public static Trajectory.Config CtoRSwitchConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, Constants.kTimeStepGlobal, 4, 2, 15);
	public static Trajectory CtoRSwitch = Pathfinder.generate(CtoRSwitchPoints, CtoRSwitchConfig);

	public static Waypoint[] CtoLSwitchPoints = new Waypoint[]{
			new Waypoint(.466344, 3.989832, 0),
			new Waypoint(3.515056, 5.81688, 0)
	};
	public static Trajectory.Config CtoLSwitchConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, Constants.kTimeStepGlobal, 4, 2, 15);
	public static Trajectory CtoLSwitch = Pathfinder.generate(CtoLSwitchPoints, CtoLSwitchConfig);

	/*****************************
	 * Experimental Trajectories *
	 *****************************/
	public static Waypoint[] RtoLScalePoints = new Waypoint[]{
			new Waypoint(.466344, 1.194816, 0),
			new Waypoint(4.486656, 1.194816, 0),
			new Waypoint(5.983224, 2.4384, Pathfinder.d2r(90)),
			new Waypoint(5.983224, 5.7912, Pathfinder.d2r(90)),
			new Waypoint(7.1628, 7.62, 0),
			new Waypoint(8.2296, 6.867114, Pathfinder.d2r(-90))
	};
	public static Trajectory.Config RtoLScaleConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, Constants.kTimeStepGlobal, 4, 2, 15);
	public static Trajectory RtoLScale = Pathfinder.generate(RtoLScalePoints, RtoLScaleConfig);
	
	public static Waypoint[] BackuptoRScalePoints = new Waypoint[]{
			new Waypoint(7.290816, 1.499616, Pathfinder.d2r(45)),
			new Waypoint(6.288024, 0.6096, Pathfinder.d2r(90))
	};	
	public static Trajectory.Config BackuptoRScaleConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, Constants.kTimeStepGlobal, 4, 2, 15);
	public static Trajectory BackuptoRScale = Pathfinder.generate(BackuptoRScalePoints, BackuptoRScaleConfig);
	
	public static Waypoint[] BackuptoRCubePoints = new Waypoint[]{
			new Waypoint(6.288024, 0.6096, Pathfinder.d2r(90)),
			new Waypoint(5.419344, 2.325624, Pathfinder.d2r(170))
	};
	public static Trajectory.Config BackuptoRCubeConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, Constants.kTimeStepGlobal, 4, 2, 15);
	public static Trajectory BackuptoRCube = Pathfinder.generate(BackuptoRCubePoints, BackuptoRCubeConfig);
	
	public static Waypoint[] CtoCubePoints = new Waypoint[]{
			new Waypoint(.466344, 3.989832, 0),
			new Waypoint(2.093976, 4.1148, 0)
	};
	public static Trajectory.Config CtoCubeConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, Constants.kTimeStepGlobal, 4, 2, 15);
	public static Trajectory CtoCube = Pathfinder.generate(CtoCubePoints, CtoCubeConfig);
	
	/*************************
	 * Elevator Trajectories *
	 *************************/
	public static Waypoint[] SwitchUpPoints = new Waypoint[]{
			new Waypoint(0, 0, 0),
			new Waypoint(Constants.kSwitchHeightMeters, 0, 0)
	};
	public static Trajectory.Config SwitchUpConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, Constants.kTimeStepGlobal, 0.775, 0.3875, 2.90625);
	public static Trajectory SwitchUp = Pathfinder.generate(SwitchUpPoints, SwitchUpConfig);
	
	public static Waypoint[] ScaleUpPoints = new Waypoint[]{
			new Waypoint(0, 0, 0),
			new Waypoint(Constants.kScaleHeightMeters, 0, 0)
	};
	public static Trajectory.Config ScaleUpConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, Constants.kTimeStepGlobal, 0.775, 0.3875, 2.90625);
	public static Trajectory ScaleUp = Pathfinder.generate(ScaleUpPoints, ScaleUpConfig);
}
