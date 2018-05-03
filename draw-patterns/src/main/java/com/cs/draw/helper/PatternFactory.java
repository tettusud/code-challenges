package com.cs.draw.helper;

import com.cs.draw.patterns.*;

/**
 * The {@code PatternFactory} class is used to create instance of Child classes of Pattern class.
 * <p>
 * They are
 * 1. Canvas
 * 2. Line
 * 3. Rectangle
 * 4. BucketFill *
 */
public class PatternFactory {

    /**
     * @param pattern
     * @return
     * @throws ApplicationException
     */
    public static Pattern getPattern(String pattern, String[] params) throws ApplicationException {
        //to make it case insensitive
        pattern = pattern.toUpperCase();
        switch (pattern) {
            case "C":
                return new Canvas(params);
            case "R":
                return new Rectangle(params);
            case "L":
                return new Line(params);
            case "B":
                return new BucketFill(params);
            default:
                throw new ApplicationException("Unknown pattern :" + pattern);
        }
    }
}
