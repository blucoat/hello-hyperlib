package org.usfirst.frc.team69.robot;

import org.usfirst.frc.team69.util.port.Port;
import org.usfirst.frc.team69.util.port.Port.Type;

/**
 * This class specifies a bunch of constant port numbers. This helps keep things
 * organized by putting all the port numbers in one place. The "Port" annotation
 * doesn't affect the code in any way, but it does allow you to generate neat
 * diagrams and check for common mistakes.
 */
public class RobotMap {
    public static class Drive {
        @Port(type = Type.PWM) public static final int LEFT_MOTOR = 0;
        @Port(type = Type.PWM) public static final int RIGHT_MOTOR = 1;
    }
}
