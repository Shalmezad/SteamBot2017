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

import edu.wpi.first.wpilibj.command.PIDCommand;
import org.usfirst.frc2619.SteamBot2017.Robot;
import org.usfirst.frc2619.SteamBot2017.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

/**
 *
 */
public class TurnNDegreesRelativePID extends PIDCommand {
	private double initialAngle = 0;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private double m_Angle;
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private CANTalon.TalonControlMode previousControlMode;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public TurnNDegreesRelativePID(double Angle) {


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("TurnNDegreesRelativePID", 0.02, 0.0, 0.1, 0.02);
        getPIDController().setContinuous(true);
        getPIDController().setAbsoluteTolerance(1.0);
        getPIDController().setInputRange(0.0, 360.0);
        getPIDController().setOutputRange(-0.5, 0.5);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        m_Angle = Angle;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return RobotMap.driveTrainAHRS.getAngle();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);

    	int sign = (int) Math.signum(output);
		double minSpeed = 0.15;
		double finalOutput = sign * Math.max(minSpeed, Math.abs(output));

		RobotMap.driveTrainLeftFrontMotor.pidWrite(finalOutput);
		RobotMap.driveTrainRightFrontMotor.pidWrite(-finalOutput);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.setTimeout(1.5);
    	previousControlMode = Robot.driveTrain.getControlMode();
    	initialAngle = RobotMap.driveTrainAHRS.getAngle();
    	RobotMap.driveTrainAHRS.setAngleAdjustment(-initialAngle);
    	getPIDController().setSetpoint(m_Angle);
    	Robot.driveTrain.setControlMode(TalonControlMode.PercentVbus);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isTimedOut() && getPIDController().onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    	RobotMap.driveTrainAHRS.setAngleAdjustment(0);
    	Robot.driveTrain.setControlMode(previousControlMode);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
