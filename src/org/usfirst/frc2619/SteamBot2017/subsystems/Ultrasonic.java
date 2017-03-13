// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2619.SteamBot2017.subsystems;

import org.usfirst.frc2619.SteamBot2017.RobotMap;
import org.usfirst.frc2619.SteamBot2017.commands.*;
import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Ultrasonic extends Subsystem {

	// set this to something accurate later
	private final double VOLTS_PER_FEET = 0.118;
	private final double VOLTS_TO_FEET_ADJUSTMENT = 0.13;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final AnalogInput ultrasonicSensor = RobotMap.ultrasonicUltrasonicSensor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public double getVolts() {

		return ultrasonicSensor.getAverageVoltage();

	}

	public double getFeet() {

		return (ultrasonicSensor.getAverageVoltage() / VOLTS_PER_FEET) + VOLTS_TO_FEET_ADJUSTMENT;// this
																									// is
																									// really,
																									// really
																									// bad.
																									// must
																									// fix

	}

	public void writeUSDebug() {

		// SmartDashboard.putDouble("UltrasonicVolts", this.getVolts());
		// SmartDashboard.putDouble("UltrasonicFeet", this.getFeet());
		// vbakfhajthia
	}

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new Scan());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
