package org.usfirst.frc.team69.robot.subsystems;

import org.usfirst.frc.team69.robot.Robot;
import org.usfirst.frc.team69.robot.RobotMap;
import org.usfirst.frc.team69.util.QuickCommand;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This class handles talking to the hardware that drives the robot, e.g. speed
 * controllers. The speed controllers and "RobotDrive" object are declared
 * private, so no code outside this class can use them directly. Instead, you
 * put logical commands in here, like "drive based on the joysticks",
 * "turn left for x seconds", etc. that other code can use.
 * 
 * If we had other hardware subsystems, like lifters, shooters, collectors, etc.
 * each would be its own Subsystem. Only one command can run on a subsystem at a
 * time, so design your subsystems accordingly.
 */
public class DriveSubsystem extends Subsystem {

    /**
     * These objects represent physical speed controllers on the robot. We don't
     * use them directly, but instead pass them to a "RobotDrive" object, which
     * can coordinate between them to drive the robot.
     * 
     * The port numbers are just constants defined in RobotMap. This helps us
     * keep organized by putting all the port numbers in one place.
     */
    private VictorSP left = new VictorSP(RobotMap.Drive.LEFT_MOTOR);
    private VictorSP right = new VictorSP(RobotMap.Drive.RIGHT_MOTOR);

    /**
     * This is a RobotDrive, something built into WPILib to help us coordinate
     * multiple motors for each wheel to drive the robot.
     */
    private RobotDrive robotDrive = new RobotDrive(left, right);

    /**
     * This is the constructor, which runs when DriveSubsystem is created (in
     * this case, during initSubsystems in Robot), after the objects above have
     * been created. We use this to set the left motors as inverted, meaning
     * their wired to drive opposite the way we want.
     */
    public DriveSubsystem() {
        left.setInverted(true);
    }

    /**
     * We're overriding (remember this means "filling in") this method, which
     * all subsystems have. This sets a "default command", which is what runs
     * when nothing else is using this subsystem. In this program, that means
     * it's running all the time.
     * 
     * In more complicated programs, you could have for example a button that
     * makes the robot drive automatically, and when that finishes you'd want it
     * to go back to user control, which is the default.
     */
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(driveCommand());
    }

    /**
     * This method is pretty dense, but it follows a very common pattern in
     * programs using HYPERLib. It creates a Command object and returns it. A
     * Command is an object that represents an action the robot can do. It
     * specifies how to start, if there is anything that needs to be repeated
     * continuously, how to know when it's done, what to do if it gets
     * interrupted, etc.
     * 
     * The Command we want to create follows a very common pattern: do the same
     * thing repeatedly for as long as you can. The QuickCommand.continuous
     * method does this. It returns a command, but as an input it needs the
     * block of code to run repeatedly. The () -> { stuff } syntax is used to
     * wrap up a block of code and pass it as a parameter. We also need to pass
     * what subsystem the command requires. Since we're already in the
     * DriveSubsystem class, we can just pass "this".
     * 
     * The actual code that goes in the command calls Robot.oi.leftDriver() to
     * get the left drive joystick (a Joystick object) and similarly for the
     * right, and passes it to robotDrive.tankDrive. This updates the speed of
     * the motors based on the current position of the joysticks.
     * 
     * Note that driveCommand() just runs once at the beginning of the program
     * and returns a Command. The Command it returns holds the code inside the
     * () -> { stuff }. This code will run whenever the Command runs. This lets
     * us separate what a command actually does from when the command will be
     * run. For example, it would be a single line of code in OIMap to change
     * this program to only drive while you were holding a button down.
     */
    public Command driveCommand() {
        return QuickCommand.continuous(this, () -> {
            robotDrive.tankDrive(Robot.oi.leftDriver(), Robot.oi.rightDriver());
        });
    }
}
