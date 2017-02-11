// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2619.SteamBot2017;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI.Port;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon driveTrainLeftFrontMotor;
    public static CANTalon driveTrainRightFrontMotor;
    public static CANTalon driveTrainRightRearMotor;
    public static CANTalon driveTrainLeftRearMotor;
    public static AnalogGyro driveTrainAnalogGyro1;
    public static Solenoid shiftersSolenoid;
    public static CANTalon shooterMotorsMotor;
    public static Solenoid gearPlungerPlunger;
    public static Solenoid gearDoorsDoors;
    public static Relay ledBoardLedSpike;
    public static DigitalOutput ledBoardLedOutput0;
    public static DigitalOutput ledBoardLedOutput1;
    public static DigitalOutput ledBoardLedOutput2;
    public static DigitalOutput ledBoardLedOutput3;
    public static CANTalon ropeClimberRopeMotor1;
    public static CANTalon ropeClimberRopeMotor2;
    public static DigitalInput ropeClimberRopeDI;
    public static Relay cameraLightsCameraSpike;
    public static CANTalon ballPickupPickupMotor;
    public static CANTalon indexerIndexerMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public static AHRS driveTrainAHRS;
    
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftFrontMotor = new CANTalon(11);
        LiveWindow.addActuator("DriveTrain", "LeftFrontMotor", driveTrainLeftFrontMotor);
        
        driveTrainRightFrontMotor = new CANTalon(2);
        LiveWindow.addActuator("DriveTrain", "RightFrontMotor", driveTrainRightFrontMotor);
        
        driveTrainRightRearMotor = new CANTalon(3);
        LiveWindow.addActuator("DriveTrain", "RightRearMotor", driveTrainRightRearMotor);
        
        driveTrainLeftRearMotor = new CANTalon(10);
        LiveWindow.addActuator("DriveTrain", "LeftRearMotor", driveTrainLeftRearMotor);
        
        driveTrainAnalogGyro1 = new AnalogGyro(0);
        LiveWindow.addSensor("DriveTrain", "AnalogGyro 1", driveTrainAnalogGyro1);
        driveTrainAnalogGyro1.setSensitivity(0.007);
        shiftersSolenoid = new Solenoid(0, 0);
        LiveWindow.addActuator("Shifters", "Solenoid", shiftersSolenoid);
        
        shooterMotorsMotor = new CANTalon(7);
        LiveWindow.addActuator("ShooterMotors", "Motor", shooterMotorsMotor);
        
        gearPlungerPlunger = new Solenoid(0, 1);
        LiveWindow.addActuator("GearPlunger", "Plunger", gearPlungerPlunger);
        
        gearDoorsDoors = new Solenoid(0, 2);
        LiveWindow.addActuator("GearDoors", "Doors", gearDoorsDoors);
        
        ledBoardLedSpike = new Relay(1);
        LiveWindow.addActuator("LedBoard", "LedSpike", ledBoardLedSpike);
        
        ledBoardLedOutput0 = new DigitalOutput(0);
        LiveWindow.addActuator("LedBoard", "LedOutput0", ledBoardLedOutput0);
        
        ledBoardLedOutput1 = new DigitalOutput(1);
        LiveWindow.addActuator("LedBoard", "LedOutput1", ledBoardLedOutput1);
        
        ledBoardLedOutput2 = new DigitalOutput(2);
        LiveWindow.addActuator("LedBoard", "LedOutput2", ledBoardLedOutput2);
        
        ledBoardLedOutput3 = new DigitalOutput(3);
        LiveWindow.addActuator("LedBoard", "LedOutput3", ledBoardLedOutput3);
        
        ropeClimberRopeMotor1 = new CANTalon(4);
        LiveWindow.addActuator("RopeClimber", "RopeMotor1", ropeClimberRopeMotor1);
        
        ropeClimberRopeMotor2 = new CANTalon(5);
        LiveWindow.addActuator("RopeClimber", "RopeMotor2", ropeClimberRopeMotor2);
        
        ropeClimberRopeDI = new DigitalInput(4);
        LiveWindow.addSensor("RopeClimber", "RopeDI", ropeClimberRopeDI);
        
        cameraLightsCameraSpike = new Relay(0);
        LiveWindow.addActuator("CameraLights", "CameraSpike", cameraLightsCameraSpike);
        
        ballPickupPickupMotor = new CANTalon(6);
        LiveWindow.addActuator("BallPickup", "PickupMotor", ballPickupPickupMotor);
        
        indexerIndexerMotor = new CANTalon(8);
        LiveWindow.addActuator("Indexer", "IndexerMotor", indexerIndexerMotor);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        driveTrainAHRS = new AHRS(Port.kMXP);
        driveTrainRightFrontMotor.setInverted(true);
        driveTrainRightRearMotor.setInverted(true);
        
     // Change Right motor to follow mode
        driveTrainRightRearMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
        // Set the device to follow the front motor with encoder 
        driveTrainRightRearMotor.set(driveTrainRightFrontMotor.getDeviceID());
        
     // Change Left motor to follow mode
        driveTrainLeftRearMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
        // Set the device to follow the front motor with encoder 
        driveTrainLeftRearMotor.set(driveTrainLeftFrontMotor.getDeviceID());
    }
}