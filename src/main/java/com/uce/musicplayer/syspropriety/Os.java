package com.uce.musicplayer.syspropriety;

//Helper Class Got From StackOverFlow
//See the original, this was modified
//https://stackoverflow.com/questions/228477/how-do-i-programmatically-determine-operating-system-in-java

import java.util.Locale;

/**
 * @author Ailton Bauque
 * @apiNote A Simple Way to detect an operating systems
 * @version 1.0.0
 * @since 2022
 * @implSpec System Propriety
 * @// FIXME: 5/6/22
 */
public final class Os {

    /**
     *Enumeration of operating systems
     *
     *@apiNote - name of operating systems
     */

    public enum OSType {
        Windows, MacOS, Linux, Other
    }

    // cached result of OS detection
    private static OSType detectedOS;

    /**
     * detect the operating system from the os.name System property and cache
     * the result
     *
     * @returns - the operating system detected
     */
    public static OSType getOperatingSystemType() {
        if (detectedOS == null) {
            String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
            if ((OS.contains("mac")) || (OS.contains("darwin"))) {
                detectedOS = OSType.MacOS;
            } else if (OS.contains("win")) {
                detectedOS = OSType.Windows;
            } else if (OS.contains("nux")) {
                detectedOS = OSType.Linux;
            } else {
                detectedOS = OSType.Other;
            }
        }
        return detectedOS;
    }

    /**
     * get the operating system user from the User.name System property
     *
     * @returns - the operating system current user detected
     */
    public static String username(){
        return System.getProperty("user.name");
    }
}
