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
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2619.SteamBot2017.Robot;
import org.usfirst.frc2619.SteamBot2017.TheChargeDashboard;

/**
 *
 */
public class DriveToTarget extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_distanceFromTarget;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveToTarget(double distanceFromTarget) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_distanceFromTarget = distanceFromTarget;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double forwardFactor = Robot.vision.getDistanceToTargetInFeet() / 10;
    	double turnFactor = Robot.vision.getRobotAngleOffsetInDegrees() / 20;
    	
    	forwardFactor = (forwardFactor > 0 ? Math.min(1, forwardFactor) : Math.max(-1, forwardFactor));
    	turnFactor = (turnFactor > 0 ? Math.min(1, turnFactor) : Math.max(-1, turnFactor));
    	
    	TheChargeDashboard.putNumber("ForwardFactor", forwardFactor);
    	TheChargeDashboard.putNumber("TurnFactor", turnFactor);
    	
    	double leftSpeed = turnFactor + forwardFactor;
    	double rightSpeed = -turnFactor + forwardFactor;
    	
    	leftSpeed = (leftSpeed > 0 ? Math.min(1, leftSpeed) : Math.max(-1, leftSpeed));
    	rightSpeed = (rightSpeed > 0 ? Math.min(1, rightSpeed) : Math.max(-1, rightSpeed));
    	
    	TheChargeDashboard.putNumber("TargetLeftSpeed", leftSpeed);
    	TheChargeDashboard.putNumber("TargetRightSpeed", rightSpeed);
    	
    	int leftSign = (int) Math.signum(leftSpeed);
    	int rightSign = (int) Math.signum(rightSpeed);
		double minSpeed = 0.15;
		double finalLeftSpeed = leftSign * Math.max(minSpeed, Math.abs(leftSpeed));
		double finalRightSpeed = rightSign * Math.max(minSpeed, Math.abs(rightSpeed));
		
		Robot.driveTrain.run(finalLeftSpeed, finalRightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.vision.hasTarget() || Robot.vision.getDistanceToTargetInFeet() < m_distanceFromTarget;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
