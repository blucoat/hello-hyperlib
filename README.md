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
