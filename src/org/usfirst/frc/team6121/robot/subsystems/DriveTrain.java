/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6121.robot.subsystems;

import org.usfirst.frc.team6121.robot.RobotMap;
import org.usfirst.frc.team6121.robot.commands.DriveTrain_TankDrive;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
*
*/
public class DriveTrain extends Subsystem {
	
	Talon leftMotor = new Talon(RobotMap.DRIVETRAIN_TALON_FRONT_LEFT);
	Talon rightMotor = new Talon(RobotMap.DRIVETRAIN_TALON_REAR_LEFT);
	//Victor frontrightMotor = new Victor(RobotMap.DRIVRTRAIN_VICTOR_FRONT_RIGHT);
	//Victor rearrightMotor = new Victor(RobotMap.DRIVETRAIN_VICTOR_REAR_RIGHT);
   
   // Put methods for controlling this subsystem
   // here. Call these from Commands.

   public void initDefaultCommand() {
       // Set the default command for a subsystem here.
       setDefaultCommand(new DriveTrain_TankDrive());
   }
	
   public void setMotors(double left, double right) {
   	left = scaleLeft(left);
   	right = scaleRight(right);
   	
   	setMotorsRaw(left, right);
   }
   
   public void setMotorsRaw(double left, double right) {
   	left = safetyTest(left);
   	right = safetyTest(right);
   	
   	leftMotor.set(left);
   	rightMotor.set(right);		
	}
   
   private double safetyTest(double motorValue) {
       motorValue = (motorValue < -1) ? -1 : motorValue;
       motorValue = (motorValue > 1) ? 1 : motorValue;
       
       return motorValue;
   }
   
   private double scaleLeft(double left) {
   	return 1.0 * left;
   }
   
   private double scaleRight(double right) {
   	return 1.0 * right;
   }
}

