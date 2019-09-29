/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

import static frc.robot.Robot.logger;


/**
 * Allows for user input from a connected Joystick to control the robot
 * @author Dat-Guy
 * @version 1.0 09/18/2019
 * @see Command
 */
public class DefaultDriveCommand extends Command {
	
	private final Drivetrain drivetrain;
	private final OI oi;
	
	/**
	 * Initializes the Command with the active drivetrain and input/output interface.
	 * @param drivetrain    Active robot drivetrain
	 * @param oi            Active robot input/output interface
	 */
	public DefaultDriveCommand(Drivetrain drivetrain, OI oi) {
		logger.fine("Initializing drive command...");
		// Store reference to active instance of the drivetrain
		this.drivetrain = drivetrain;
		// Store reference to active instance of the input/output object
		this.oi = oi;
		// Flag drivetrain as in use.
		requires(Robot.drivetrain);
		logger.fine("Initialized!");
	}
	
	/**
	 * Causes the robot to change motor output based on Joystick position;
	 */
	@Override
	protected void execute() {
		// Get left joystick input
		double left = -oi.drive.getRawAxis(RobotMap.Controller.RIGHT_Y);
		// Get right joystick input
		double right = oi.drive.getRawAxis(RobotMap.Controller.LEFT_X);
		
		// Pass left and right inputs to the drivetrain's drive method
		drivetrain.drive(left, right);
	}
	
	
	/**
	 * This command will never terminate of its own accord.
	 * @return false
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	
	/**
	 * Tells the robot to stop the motors when we interrupt the drive command.
	 */
	@Override
	protected void interrupted() {
		//Since we're about to lose control of the drive-train, stop it to prevent the robot from driving off.
		drivetrain.stop();
	}
}
