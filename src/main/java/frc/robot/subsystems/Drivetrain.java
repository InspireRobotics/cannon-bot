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
import frc.robot.RobotMap;
import frc.robot.commands.DefaultDriveCommand;

import static frc.robot.Robot.oi;

/**
 * Controls all drive motors responsible for gross movement of the robot.
 * @author Dat-Guy
 * @version 1.0 09/18/2019
 * @see Subsystem
 */
public class Drivetrain extends Subsystem {
	
	private double DRIVEPWR = 0.75;
	
	private Spark FrontLeft = new Spark(RobotMap.DriveTrain.LEFT_FRONT);
	private Spark BackLeft = new Spark(RobotMap.DriveTrain.LEFT_BACK);
	
	private Spark FrontRight = new Spark(RobotMap.DriveTrain.RIGHT_FRONT);
	private Spark BackRight = new Spark(RobotMap.DriveTrain.RIGHT_BACK);
	
	private DifferentialDrive differentialDrive = new DifferentialDrive(new SpeedControllerGroup(FrontLeft, BackLeft), new SpeedControllerGroup(FrontRight, BackRight));
	
	/**
	 * Tells the motors to rotate based on given power percentages
	 * @param left  Power percentage for the motors on the left side of the robot.
	 * @param right Power percentage for the motors on the right side of the robot.
	 */
	public void drive(double left, double right) {
		differentialDrive.tankDrive(Math.abs(left * DRIVEPWR) > 0.3 ? left : 0, Math.abs(right * DRIVEPWR) > 0.3 ? right : 0);
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
