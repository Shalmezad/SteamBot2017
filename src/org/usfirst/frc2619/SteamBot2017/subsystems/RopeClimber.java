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
import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class RopeClimber extends Subsystem {
	
	private static final int CURRENT_LIMIT = 40;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon ropeMotor1 = RobotMap.ropeClimberRopeMotor1;
    private final CANTalon ropeMotor2 = RobotMap.ropeClimberRopeMotor2;
    private final DigitalInput ropeDI = RobotMap.ropeClimberRopeDI;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    
    //DEFAULT COMMAND
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    
    //RUN
    public void run(double motorSpeed){
		ropeMotor1.set(motorSpeed);
		ropeMotor2.set(-motorSpeed);
	}
    
    
    //STOP
    public void stop(){
    	run(0);
    }
    
    
    //SET MOTOR MODES
    public void setMotorModes(){
    	ropeMotor1.changeControlMode(TalonControlMode.PercentVbus);
		ropeMotor2.changeControlMode(TalonControlMode.PercentVbus);
    }
    
    
    //CHECK DI						
    public boolean checkDI(){
    	return ropeDI.get();
    }
    
    
    //CURRENT LIMIT
    public void currentLimiting(){
    	ropeMotor1.setCurrentLimit(CURRENT_LIMIT);
    	ropeMotor1.EnableCurrentLimit(true);
    	ropeMotor2.setCurrentLimit(CURRENT_LIMIT);
    	ropeMotor2.EnableCurrentLimit(true);
    }
}

