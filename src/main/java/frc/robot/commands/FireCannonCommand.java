/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Pneumatics;

/**
 * Opens the pressure valve to the cannon for a given period of time.
 * @author Dat-Guy
 * @version 1.0 09/18/2019
 * @see Command
 */
public class FireCannonCommand extends Command {
	
	private long start;
	private final long fireTimeMillis;
	private final Pneumatics pneumatics;
	
	/**
	 * Initializes the Command with the active pneumatics and a constant firing time
	 * @param pneumatics        Active robot pneumatics
	 * @param fireTimeMillis    Time valve should be open for
	 */
	public FireCannonCommand(Pneumatics pneumatics, long fireTimeMillis) {
		requires(Robot.pneumatics);
		this.fireTimeMillis = fireTimeMillis;
		this.pneumatics = pneumatics;
	}
	
	/**
	 * Opens the air valve, and gets the time the valve was opened.
	 */
	@Override
	protected void initialize() {
		start = System.currentTimeMillis();
		pneumatics.open();
		
	}
	
	/**
	 * Tells the command to end after the specified amount of time.
	 * @return Returns true if the valve has been open for at least the specified amount of time, otherwise returns false.
	 */
	@Override
	protected boolean isFinished() {
		return (start + fireTimeMillis) <= System.currentTimeMillis();
	}
	
	/**
	 * Closes the valve on a successful command exit.
	 */
	@Override
	protected void end() {
		pneumatics.close();
	}
	
	/**
	 * Closes the valve if the command is interrupted.
	 */
	@Override
	protected void interrupted() {
		pneumatics.close();
	}
}
