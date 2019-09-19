/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * Entry point for robot code execution
 * @author Dat-Guy
 * @version 1.0 09/18/2019
 */
public final class Main {
	private Main() {
	
	}
	
	/**
	 * Main initialization function. Does not perform robot initialization.
	 */
	public static void main(String... args) {
		RobotBase.startRobot(Robot::new);
	}
}
