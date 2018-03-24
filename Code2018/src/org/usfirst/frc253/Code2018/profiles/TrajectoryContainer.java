package org.usfirst.frc253.Code2018.profiles;

import jaci.pathfinder.Trajectory;

public class TrajectoryContainer {

	Trajectory trajec;
	boolean isInverted;
	
	public TrajectoryContainer(Trajectory trajec, boolean isInverted){
		this.trajec = trajec;
		this.isInverted = isInverted;
	}
	
	public Trajectory getTrajec(){
		return trajec;
	}
	
	public boolean isInverted(){
		return isInverted;
	}
}
