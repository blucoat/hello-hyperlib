
package org.usfirst.frc.team69.robot;

import org.usfirst.frc.team69.util.HYPERRobot;
import org.usfirst.frc.team69.util.oi.OI;

/**
 * This is the "main class" of the program. By extending HYPERRobot, you get a
 * lot of functionality "for free". All you need to do is fill in the four
 * "init" methods, and HYPERRobot will call them at the appropriate times. After
 * that, any commands will run when they're supposed to automatically.
 * 
 * Note that for both OI and DriveSubsystem, we create a variable in one line,
 * but initialize it somewhere else. This is because getting everything
 * initialized in the right order can be difficult, so HYPERRobot handles that
 * for us by calling the "init" methods in the right order.
 */
public class Robot extends HYPERRobot {

    /**
     * OI stands for "operator interface." This class comes from HYPERLib. It
     * manages all the joysticks and buttons.
     */
    public static OI oi;

    /**
     * Declare subsystems here as "public static."  Examples:
     * public static DriveSubsystem drive;
     * public static ShooterSubsystem shooter;
     */

    /**
     * We override this method to set up any subsystems we create.  For example:
     * drive = new DriveSubsystem();
     * shooter = new ShooterSubsystem();
     */
    @Override
    protected void initSubsystems() {
    }

    /**
     * We don't need to use this for now.  This is where we initialize classes
     * that are neither subsystems nor command.  Examples: vision processing,
     * user drive modes.
     */
    @Override
    protected void initHelpers() {
    }

    /**
     * We override ("fill in with our stuff") this method to initialize the OI.
     * The constructor for OI needs a "map" of how the joysticks are layed out,
     * which we specify in the OIMap class.
     * 
     * Note that we don't create an OIMap object, but instead pass
     * "OIMap.class", which is of type "Class". You can think of this as just
     * passing the whole source code of OIMap.java, which OI then reads in order
     * to set up the joysticks.
     * 
     * Don't think to hard about this method, it's the same in every program.
     */
    @Override
    protected void initOI() {
        oi = new OI(OIMap.class, true);
    }
    
    /**
     * This is also mostly the same every time.
     */
    @Override
    protected void initCommands() {
        oi.initCommands();
    }

}
