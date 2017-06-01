
package org.usfirst.frc.team69.robot;

import org.usfirst.frc.team69.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team69.util.HYPERRobot;
import org.usfirst.frc.team69.util.oi.OI;

/**
 * This is the "main class" of the program. By extending HYPERRobot, you get a
 * lot of functionality "for free". All you need to do is fill in the four
 * "init" methods, and HYPERRobot will call them at the appropriate times. After
 * that, any commands will run when they're supposed to automatically.
 * 
 * This robot only uses two simple parts: the motors on the drivetrain, and the
 * joysticks which drive them. The way they get connected is in the
 * DriveSubsystem class, where we create a "command" which checks the joysticks
 * and uses that to drive the robot.
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
     * This is an instance of the DriveSubsystem class, which we define in the
     * DriveSubsystem.java file. This manages how to control the motors which
     * drive the wheels.
     */
    public static DriveSubsystem drive;

    /**
     * We override ("fill in with our stuff") this method to initialize the OI.
     * The constructor for OI needs a "map" of how the joysticks are layed out,
     * which we specify in the OIMap class.
     * 
     * Note that we don't create an OIMap object, but instead pass
     * "OIMap.class", which is of type "Class". You can think of this as just
     * passing the whole source code of OIMap.java, which OI then reads in order
     * to set up the joysticks.
     */
    @Override
    protected void initOI() {
        oi = new OI(OIMap.class, true);
    }

    /**
     * We override this method to set up any subsystems we create.
     */
    @Override
    protected void initSubsystems() {
        drive = new DriveSubsystem();
    }

    /**
     * We don't need to use this for now.
     */
    @Override
    protected void initHelpers() {
    }

    /**
     * You might think we need to use this, but we don't right now. The only
     * command we need is a "default command", which comes with the
     * DriveSubsystem. If we wanted to tie other commands to buttons, you would
     * list the commands in OIMap, and put "oi.initCommands()" here.
     */
    @Override
    protected void initCommands() {
    }

}
