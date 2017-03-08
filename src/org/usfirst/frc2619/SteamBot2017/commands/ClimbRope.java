// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2619.SteamBot2017.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2619.SteamBot2017.Robot;
import org.usfirst.frc2619.SteamBot2017.TheChargeDashboard;

/**
 *
 */
public class ClimbRope extends Command {
	private static final double SPEED = 1;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public ClimbRope() {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.ropeClimber);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.ropeClimber.setMotorModes();
		Robot.ropeClimber.currentLimiting();
		Robot.cANLights.LightRun(0, 255, 0);
		Robot.ledBoard.bitmap(3);
		this.setTimeout(2);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double time = Timer.getMatchTime();
		if (/*time <= 30 && */isTimedOut() && !Robot.ropeClimber.isAtPlate()){
			Robot.ropeClimber.run(SPEED);
			//TheChargeDashboard.putString("ClimbRopeDebug", "Can Climb");
		}
		else {
			//TheChargeDashboard.putString("ClimbRopeDebug", "Cannot Climb");
			end();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.ropeClimber.stop();
		Robot.ledBoard.bitmapRandom();
		Robot.cANLights.colorAlliance();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
