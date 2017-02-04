// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2619.PlyBot2017.subsystems;

import org.usfirst.frc2619.PlyBot2017.MathUtil;
import org.usfirst.frc2619.PlyBot2017.Robot;
import org.usfirst.frc2619.PlyBot2017.RobotMap;
import org.usfirst.frc2619.PlyBot2017.commands.*;
import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class DriveTrain extends Subsystem {
	private final double TICKS_PER_FOOT = 4273;
	
	private double Destination = 0;
	private double numFeet = 0;
	
	public boolean isReversed = false;
	
	public int DELIN_POW = 3;
	public double DEADBAND_X = 0.2;
	public double DEADBAND_Y = 0.1;
	public double DEADBAND_TWIST = 0.2;
	public double TURN_OUTER_SPEED = 0.5;
	public double TURN_INNER_SPEED = -0.5;
	public int CURRENT_LIMIT = 8;

	
	private static final String DELIN_POW_KEY = "DELIN_POW";
	private static final String DEADBAND_X_KEY = "DEADBAND_X";
	private static final String DEADBAND_Y_KEY = "DEADBAND_Y";
	private static final String DEADBAND_TWIST_KEY = "DEADBAND_TWIST";
	private static final String TURN_OUTER_SPEED_KEY = "TURN_OUTER_SPEED";
	private static final String TURN_INNER_SPEED_KEY = "TURN_INNER_SPEED";
	private static final String CURRENT_LIMIT_KEY = "CURRENT_LIMIT";
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon leftFrontMotor = RobotMap.driveTrainLeftFrontMotor;
    private final CANTalon rightFrontMotor = RobotMap.driveTrainRightFrontMotor;
    private final CANTalon rightRearMotor = RobotMap.driveTrainRightRearMotor;
    private final CANTalon leftRearMotor = RobotMap.driveTrainLeftRearMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final AHRS ahrs = RobotMap.driveTrainAHRS;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void writeDefaultValues() {
    	SmartDashboard.putNumber(DELIN_POW_KEY, DELIN_POW);
    	SmartDashboard.putNumber(DEADBAND_X_KEY, DEADBAND_X);
    	SmartDashboard.putNumber(DEADBAND_Y_KEY, DEADBAND_Y);
    	SmartDashboard.putNumber(DEADBAND_TWIST_KEY, DEADBAND_TWIST);
    	SmartDashboard.putNumber(TURN_OUTER_SPEED_KEY, TURN_OUTER_SPEED);
    	SmartDashboard.putNumber(TURN_INNER_SPEED_KEY, TURN_INNER_SPEED);
    	SmartDashboard.putInt(CURRENT_LIMIT_KEY, CURRENT_LIMIT);
    }
    
    public void readControlValues() {
    	DELIN_POW = SmartDashboard.getInt(DELIN_POW_KEY);
    	DEADBAND_X = SmartDashboard.getNumber(DEADBAND_X_KEY);
    	DEADBAND_Y = SmartDashboard.getNumber(DEADBAND_Y_KEY);
    	DEADBAND_TWIST = SmartDashboard.getNumber(DEADBAND_TWIST_KEY);
    	TURN_OUTER_SPEED = SmartDashboard.getNumber(TURN_OUTER_SPEED_KEY);
    	TURN_INNER_SPEED = SmartDashboard.getNumber(TURN_INNER_SPEED_KEY);
    	CURRENT_LIMIT = SmartDashboard.getInt(CURRENT_LIMIT_KEY);
    }
    
    public void writeDebugValues(){
    	SmartDashboard.putNumber("IMU_TotalYaw", ahrs.getAngle());
        SmartDashboard.putNumber("IMU_YawRateDPS", ahrs.getRate());
        SmartDashboard.putBoolean("IMU_Connected", ahrs.isConnected());
        SmartDashboard.putBoolean("IMU_IsCalibrating", ahrs.isCalibrating());
        SmartDashboard.putNumber("IMU_Yaw", ahrs.getYaw());
        SmartDashboard.putNumber("IMU_Pitch", ahrs.getPitch());
        SmartDashboard.putNumber("IMU_Roll", ahrs.getRoll());
        // Connectivity Debugging Support                                     
        SmartDashboard.putNumber(   "IMU_Byte_Count",       ahrs.getByteCount());
        SmartDashboard.putNumber(   "IMU_Update_Count",     ahrs.getUpdateCount());
        SmartDashboard.putNumber("LeftMotorOutputCurrent", leftFrontMotor.getOutputCurrent());
        SmartDashboard.putNumber("RightMotorOutputCurrent", rightFrontMotor.getOutputCurrent());
    }
    
	public void run(double leftSpeed, double rightSpeed){
		writeDebugValues();
		SmartDashboard.putNumber("LeftSpeed", leftSpeed);
		SmartDashboard.putNumber("RightSpeed", rightSpeed);
		if(!isReversed) {
	    	leftFrontMotor.set(leftSpeed);
	    	
	    	rightFrontMotor.set(rightSpeed);
	    	
	    }
		else {
			leftFrontMotor.set(-1*rightSpeed);
	    	
	    	rightFrontMotor.set(-1*leftSpeed);
	    	
		}
	}
    
    public double getFeet() {
    	return (leftFrontMotor.getEncPosition()) / TICKS_PER_FOOT; // Gives the number of ticks the left front motor is currently at in feet.
    }
    
    public double getTicks() {
    	return (leftFrontMotor.getEncPosition()); // Gives the number of ticks the left front motor is currently at.
    }
    
    public void sendFeet(double f) {
    	Destination = 0;
    	numFeet = f;
    	Destination = getTicks() + (((numFeet * 1.017) - (12.147 / 12)) * TICKS_PER_FOOT);
    	SmartDashboard.putNumber("Destination", Destination);
    }
    
    public boolean isAtDestination() {
    	SmartDashboard.putNumber("getTicks()", getTicks());
    	if (numFeet > 0)
    	{
        	return getTicks() >= Destination;
    	}
    	else {
    		return getTicks() <= Destination;
    	}
    }
    
    public void updateCurrentLimit(){
    	  //Set Current Limiting value from int CurrentLimit   
        RobotMap.driveTrainLeftRearMotor.setCurrentLimit(CURRENT_LIMIT);
        RobotMap.driveTrainRightRearMotor.setCurrentLimit(CURRENT_LIMIT);
        RobotMap.driveTrainLeftFrontMotor.setCurrentLimit(CURRENT_LIMIT);
        RobotMap.driveTrainRightFrontMotor.setCurrentLimit(CURRENT_LIMIT);
    }
    
    public void disableCurrentLimit(){
    	RobotMap.driveTrainLeftRearMotor.EnableCurrentLimit(false);
    	RobotMap.driveTrainRightRearMotor.EnableCurrentLimit(false);
    	RobotMap.driveTrainLeftFrontMotor.EnableCurrentLimit(false);
    	RobotMap.driveTrainRightFrontMotor.EnableCurrentLimit(false);
    }
    
    public void enableCurrentLimit(){
    	updateCurrentLimit();
    	RobotMap.driveTrainLeftRearMotor.EnableCurrentLimit(true);
    	RobotMap.driveTrainRightRearMotor.EnableCurrentLimit(true);
    	RobotMap.driveTrainLeftFrontMotor.EnableCurrentLimit(true);
    	RobotMap.driveTrainRightFrontMotor.EnableCurrentLimit(true);
    }
    
    public void stop() {
    	Robot.driveTrain.run(0, 0);
    }
    
    public double getDegrees(){
    	return ahrs.getAngle();
    }
    
    public double getYaw(){
    	return ahrs.getYaw();
    }
    
    public void relTurn(double turnTo, double speed){
    	double leftSpeed =0, rightSpeed = 0;
    	double direction = MathUtil.calcDirection(getDegrees(), turnTo);
    	if(direction >= 0){
    		leftSpeed = speed;
    		rightSpeed = 0;
			//run(speed, -speed);
			SmartDashboard.putString("Direction", "right");
    	}
    	else if(direction < 0){
    		leftSpeed = 0;
    		rightSpeed = speed;
    		//run(-speed, speed);
    		SmartDashboard.putString("Direction", "left");
    	}
    	else{
    		leftSpeed = 0;
    		rightSpeed = 0;
    		//run(0,0);
    		SmartDashboard.putString("Direction", "none");
    	}
    	run(leftSpeed,rightSpeed);
	}
    
    public void absTurn(double degreeChange, double speed){
    	double leftSpeed = 0, rightSpeed = 0;
    	if (degreeChange > 0){
    		leftSpeed = TURN_OUTER_SPEED;
    		rightSpeed = -1 * TURN_INNER_SPEED;
    	}
    	else if (degreeChange < 0){
    		rightSpeed = TURN_OUTER_SPEED;
    		leftSpeed = -1 * TURN_INNER_SPEED;
    	}
    	run(leftSpeed,rightSpeed);
	}
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new TankDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

