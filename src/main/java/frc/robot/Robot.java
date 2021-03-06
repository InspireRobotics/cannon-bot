/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.commands.FireCannonCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Pneumatics;

import java.io.Console;
import java.util.logging.*;

/**
 * Main robot class; this class contains all subsystems and commands to run given different conditions.
 * @author Dat-Guy
 * @version 1.0 09/18/2019
 * @see TimedRobot
 */
public class Robot extends TimedRobot {
    
    public static Drivetrain drivetrain = new Drivetrain();
    public static Pneumatics pneumatics = new Pneumatics();
    public static OI oi;
    public static Logger logger = Logger.getLogger(Robot.class.getName());
	
	/**
	 * Initializes the input/output interface, and sets up the fire command
	 */
    @Override
    public void robotInit() {
        oi = new OI();
        oi.fireButton.whenPressed(new FireCannonCommand(pneumatics, 500));
        //Setup the logger
	    StreamHandler handler = new StreamHandler(System.out, new SimpleFormatter());
	    handler.setLevel(Level.FINE);
	    logger.addHandler(handler);
	    logger.setLevel(Level.FINE);
    }
    
    @Override
    public void robotPeriodic(){
    	drivetrain.logCurrentPower();
    }
	
	/**
	 * Stops all running commands, and disables the drivetrain and pneumatics
	 */
    @Override
    public void disabledInit() {
    	logger.info("Disabling robot!");
    	Scheduler.getInstance().removeAll();
    	//In case default stop failed...
        drivetrain.stop();
        pneumatics.close();
    }
    
    @Override
    public void disabledPeriodic(){
    	//Stops the robot from complaining
    }
	
	/**
	 * Queues the drive command
	 */
    @Override
    public void teleopInit() {
    	logger.info("Enabling robot!");
        Scheduler.getInstance().add(new DefaultDriveCommand(drivetrain, oi));
    }
    
	/**
	 * Runs all queued commands; this also allows the cannon to be fired,
	 * as the FireCannonCommand is run when added to the queue.
	 */
    @Override
    public void teleopPeriodic() {
	    Scheduler.getInstance().run();
    }
}
