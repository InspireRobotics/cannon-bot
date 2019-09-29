/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import static frc.robot.Robot.logger;

/**
 * Controls valve responsible for firing the cannon.
 * @author Dat-Guy
 * @version 1.0 09/18/2019
 * @see Subsystem
 */
public class Pneumatics extends Subsystem {
	
	private Jaguar valve = new Jaguar(RobotMap.Cannon.VALVE);
	
	
	/**
	 * Opens the value, allowing pressurized air to be released into the chamber
	 */
	public void open(){
		logger.fine("Opening valve!");
		valve.set(1.0);
	}
	
	/**
	 * Closes the valve, restricting pressurized air from flowing into the chamber
	 */
	public void close(){
		logger.fine("Closing valve!");
		valve.set(0.0);
	}
	
	/**
	 * Sets the default command to null (none)
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(null);
	}
}
