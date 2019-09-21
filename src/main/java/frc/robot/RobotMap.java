/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Outlines all constants for ports concerning motors/pneumatic control and user input.
 * @author Dat-Guy
 * @version 1.0 09/18/2019
 */
public class RobotMap {
	
	public static class DriveTrain {
		public static int LEFT_FRONT = 0;
		public static int LEFT_BACK = 1;
		
		public static int RIGHT_FRONT = 2;
		public static int RIGHT_BACK = 3;
	}
	
	public static class Cannon {
		public static int VALVE = 0;
	}
	
	public static class Controller {
		public static int LEFT_X = 0;
		public static int LEFT_Y = 1;
		public static int RIGHT_X = 4;
		public static int RIGHT_Y = 5;
		
		public static int A_BUTTON = 1;
		public static int B_BUTTON = 2;
		public static int X_BUTTON = 3;
		public static int Y_BUTTON = 4;
		public static int LEFT_SHOULDER = 5;
		public static int RIGHT_SHOULDER = 6;
	}
}
