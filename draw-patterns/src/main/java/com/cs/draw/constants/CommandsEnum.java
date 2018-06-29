package com.cs.draw.constants;

import java.util.Arrays;

/**
 *
 */
public enum CommandsEnum {
    CANVAS("C"),
    RECTANGLE("R"),
    LINE("L"),
    BUCKETFILL("B"),
    QUIT("Q"),
    HELP("H");

    private String cmd;

    CommandsEnum(String cmd){
        this.cmd=cmd;
    }

    public String cmd(){
        return cmd;
    }

    /**
     * @return the Enum representation for the given string.
     * @throws IllegalArgumentException if unknown string.
     */
    public static CommandsEnum fromString(String s) throws IllegalArgumentException {
        return Arrays.stream(CommandsEnum.values())
                .filter(v -> v.cmd.equals(s))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown pattern: " + s));
    }

}
