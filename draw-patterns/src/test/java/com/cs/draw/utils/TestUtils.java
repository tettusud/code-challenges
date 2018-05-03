package com.cs.draw.utils;


/**
 * Utility class to build expected result against the actual output.
 */
public class TestUtils {

    public String createCanvas(int w, int h) {
        return "----------------------\r\n" +
                "|                    |\r\n" +
                "|                    |\r\n" +
                "|                    |\r\n" +
                "|                    |\r\n" +
                "----------------------\r\n";
    }

    public String createHorizontalLine() {
        return "----------------------\r\n" +
                "|                    |\r\n" +
                "|xxxxxx              |\r\n" +
                "|                    |\r\n" +
                "|                    |\r\n" +
                "----------------------";
    }

    public String createVerticalLine() {
        return "----------------------\r\n" +
                "|                    |\r\n" +
                "|xxxxxx              |\r\n" +
                "|     x              |\r\n" +
                "|     x              |\r\n" +
                "----------------------";
    }

    public String createRectangle() {
        return "----------------------\r\n" +
                "|             xxxxx  |\r\n" +
                "|             x   x  |\r\n" +
                "|             xxxxx  |\r\n" +
                "|                    |\r\n" +
                "----------------------\r\n";
    }


    public String createBucketFill() {
        return "----------------------\r\n" +
                "|oooooooooooooxxxxxoo|\r\n" +
                "|xxxxxxooooooox   xoo|\r\n" +
                "|     xoooooooxxxxxoo|\r\n" +
                "|     xoooooooooooooo|\r\n" +
                "----------------------";
    }


}
