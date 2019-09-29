/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DefaultDriveCommand;

import static frc.robot.Robot.logger;
import static frc.robot.Robot.oi;
import static java.lang.Math.floor;

/**
 * Controls all drive motors responsible for gross movement of the robot.
 * @author Dat-Guy
 * @version 1.0 09/18/2019
 * @see Subsystem
 */
public class Drivetrain extends Subsystem {
	
	private double DRIVEPWR = 0.85;
	private double SPINPWR = 0.85;
	private double DEADZONE = 0.55;
	
	private Spark frontLeft = new Spark(RobotMap.DriveTrain.LEFT_FRONT);
	private Spark backLeft = new Spark(RobotMap.DriveTrain.LEFT_BACK);
	
	private Spark frontRight = new Spark(RobotMap.DriveTrain.RIGHT_FRONT);
	private Spark backRight = new Spark(RobotMap.DriveTrain.RIGHT_BACK);
	
	private DifferentialDrive differentialDrive = new DifferentialDrive(new SpeedControllerGroup(frontLeft, backLeft), new SpeedControllerGroup(frontRight, backRight));
	
	public Drivetrain(){
		differentialDrive.setDeadband(DEADZONE);
	}
	
	/**
	 * Tells the motors to rotate based on given power percentages
	 * @param left  Power percentage for the motors on the left side of the robot.
	 * @param right Power percentage for the motors on the right side of the robot.
	 */
	public void drive(double left, double right) {
		differentialDrive.arcadeDrive(Math.abs(left * DRIVEPWR) > DEADZONE ? left * DRIVEPWR : 0, right * SPINPWR);
	}
	
	public void logCurrentPower() {
		logger.finer("Left power: " + floor((frontLeft.getSpeed() + backLeft.getSpeed()) * 50) / 100 + " === Right power : " + floor((frontRight.getSpeed() + backRight.getSpeed()) * 50) / 100);
	}
	
	
	/**
	 * Tells the motors to not rotate; the motors do NOT have brakes.
	 */
	public void stop(){
		differentialDrive.stopMotor();
	}
	
	/**
	 * Sets the default command to the user-controlled drive command.
	 */
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new DefaultDriveCommand(this, oi));
	}
}
