package org.usfirst.frc.team69.robot;

import org.usfirst.frc.team69.util.oi.MapJoystick;
import org.usfirst.frc.team69.util.oi.MapJoystick.Role;
import org.usfirst.frc.team69.util.oi.MapJoystick.Type;

/**
 * This file specifies what joysticks/buttons are used, and what ports they are on.
 * It also lets us tie buttons to commands, e.g. "run this command while this button
 * is held".
 */
public class OIMap {
    
    @MapJoystick(port = 0, role = Role.LEFT_DRIVER, type = Type.LOGITECH_2_AXIS)
    public static class LeftJoystick {
        // If we used any buttons on the left joystick, they would go here.
    }
    
    @MapJoystick(port = 1, role = Role.RIGHT_DRIVER, type = Type.LOGITECH_2_AXIS)
    public static class RightJoystick {
        // same goes for the right
    }

}
