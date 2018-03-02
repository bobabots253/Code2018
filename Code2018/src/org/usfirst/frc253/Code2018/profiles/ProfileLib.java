package org.usfirst.frc253.Code2018.profiles;

import java.util.ArrayList;

public class ProfileLib {	

	public static ArrayList<MotionProfileData> LtoLSwitch = new ArrayList<MotionProfileData>() {{
		add(new MotionProfileData("LStartToLSwitch_left.csv", false, false, false));
		add(new MotionProfileData("LStartToLSwitch_right.csv", false, false, false));
	}};
	public static ArrayList<MotionProfileData> RToRSwitch = new ArrayList<MotionProfileData>() {{
		add(new MotionProfileData("RtoRswitch_left.csv", false, false, false));
		add(new MotionProfileData("RtoRswitch_right.csv", false, false, false));
	}};
} 
