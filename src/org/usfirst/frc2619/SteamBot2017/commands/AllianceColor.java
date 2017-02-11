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
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.InstantCommand;
import org.usfirst.frc2619.SteamBot2017.Robot;

/**
 *
 */
public class AllianceColor extends InstantCommand {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AllianceColor() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.cANLights);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    
    }
    // Called once when this command runs
    protected void initialize() {
    	
    	DriverStation ds = DriverStation.getInstance();
    	if (ds.getAlliance() == DriverStation.Alliance.Red) {
            Robot.cANLights.LightRun(255, 0, 0);
            Robot.cANLights.displayCANLightValues(255, 0, 0);
        } else if (ds.getAlliance() == DriverStation.Alliance.Blue) {
        	Robot.cANLights.LightRun(0, 0, 255);
            Robot.cANLights.displayCANLightValues(0, 0, 255);
        } else if (ds.getAlliance() == DriverStation.Alliance.Invalid) {
        	Robot.cANLights.LightRun(255, 255, 0);
            Robot.cANLights.displayCANLightValues(255, 255, 0); // yellow
        }
    	
    

}
}
