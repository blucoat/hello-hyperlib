# hello-hyperlib
Simple project demonstrating how to use HYPERLib.  This is the code that I walked everyone through in the meeting on 6/1/17.  You can clone this repo straight into eclipse if you want to play with it.

Here's how it's layed out:
```
.
├── build.properties                  // settings for how to build the project (ignore it)
├── build.xml                         // ant file for how to build the project (ignore it)
├── lib
│   ├── hyperlib-0.3.1.jar            // hyperlib library
│   └── hyperlib-0.3.1-sources.jar    // hyperlib sources (so you can get docs in eclipse)
└── src
    └── org
        └── usfirst
            └── frc
                └── team69
                    └── robot
                        ├── OIMap.java                // describes where joysticks are 
                        ├── Robot.java                // main code, glues everything together
                        ├── RobotMap.java             // decribes what ports the motors are on
                        └── subsystems
                            └── DriveSubsystem.java   // code for how to drive the robot
```
# Going further: binding a command to a button
As it is, there's only one command, and it's always running.  To demonstrate the power of commands, lets see how we can change the code so the driving only works while the user is holding a button.  This requires two parts: changing the default command to a "stop command" which turns the motors off, and adding a button in OIMap that triggers the drive command.

You might wonder if we really need a stop command, or if we can get the robot to stop by just not running any command.  This can be dangerous, because if we don't update the motors, they will just run at whatever speed we last left them.  (In reality, there is a MotorSafety feature which will stop certain motors if you don't update them for a timeout, but that isn't always enabled, so I wouldn't rely on it).

## Step 1: create a stop command
In DriveSubsystem.java, add the following method:
```
public Command stopCommand() {
    return QuickCommand.continuous(this, () -> {
        robotDrive.tankDrive(0, 0);
    });
}
```

## Step 2: change the default command to stop
Again in DriveSubsystem.java, change the `initDefaultCommand` method:
```
protected void initDefaultCommand() {
    setDefaultCommand(stopCommand());
}
```
At this point, you can run the code, and nothing should happen, even when you press the joysticks.  Progress!

## Step 3: bind the drive command to a button
In OIMap.java, add this entry to LeftJoystick (or whatever joystick you like):
```
public static class LeftJoystick {
    @WhileHeld(1) public final Command drive = Robot.drive.driveCommand();
}
```
This does what it looks like: it runs the drive command as long as button 1 on the left joystick is held.

## Step 4: initialize commands in initCommands
We only have to do this once.  We need to have the program actually set up the commands we put in OIMap.  To do that, we fill in `initCommands` in Robot.java:
```
protected void initCommands() {
    oi.initCommands();
}
```

Now, if you run the code, pushing the joysticks should only work while button 1 on the left joystick is held.  Otherwise, the robot should stop.

Note: I wrote this late at night without testing, so it might not work exactly due to typos.  I promise, the ideas are all right though.
