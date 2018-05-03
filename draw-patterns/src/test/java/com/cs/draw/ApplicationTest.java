package com.cs.draw;


import com.cs.draw.utils.TestUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/***
 * Test case of Application class.
 * It captures all possible input correct and incorrect.
 */
public class ApplicationTest {
    private Application application;
    private TestUtils testUtils;
    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private String actual = null;
    private String expected = null;

    @Before
    public void setUp() {
        this.application = new Application();
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
        this.testUtils = new TestUtils();
    }

    /**
     * Creating canvas with proper input
     */
    @Test
    public void testCanvas() {
        int w = 20;
        int h = 4;
        String data = "C " + w + " " + h;
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            application.start();
            this.actual = outContent.toString();
            this.expected = this.testUtils.createCanvas(w, h);
            this.log();
            assertEquals(this.contains(), true);
        } finally {
            System.setIn(stdin);
        }
    }

    /**
     * To create canvas two inputs w and h needs to be passed with one input it should fail
     */
    @Test
    public void testCanvasIllegalArgument() {
        int w = 20;
        String data = "C " + w + " ";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            application.start();
            this.actual = outContent.toString();
            this.expected = "Invalid number of arguments";
            this.log();
            assertEquals(this.contains(), true);
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void testLineHorizontal() {
        int w = 20;
        int h = 4;
        String data = "C " + w + " " + h + " \r";
        InputStream stdin = System.in;
        try {

            data = data.concat("L 1 2 6 2");
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            application.start();
            this.actual = outContent.toString();
            this.expected = this.testUtils.createHorizontalLine();
            this.log();
            assertEquals(this.contains(), true);
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void testLineVertical() {
        int w = 20;
        int h = 4;
        String data = "C " + w + " " + h + " \r";
        InputStream stdin = System.in;
        try {

            data = data.concat("L 1 2 6 2 \r");
            data = data.concat("L 6 3 6 4");
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            application.start();

            this.actual = outContent.toString();
            this.expected = this.testUtils.createVerticalLine();
            this.log();
            assertEquals(this.contains(), true);
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void testLineNeitherHorizontalNorVertical() {
        int w = 20;
        int h = 4;
        String data = "C " + w + " " + h + " \r";
        InputStream stdin = System.in;
        try {
            data = data.concat("L 1 2 6 4");
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            application.start();
            this.actual = outContent.toString();
            this.expected = "Currently only vertical or horizontal lines is supported";
            this.log();
            assertEquals(this.contains(), true);
        } finally {
            System.setIn(stdin);
        }
    }


    @Test
    public void testLineRectangle() {
        int w = 20;
        int h = 4;
        String data = "C " + w + " " + h + " \r";
        InputStream stdin = System.in;
        try {
            data = data.concat("R 14 1 18 3");
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            application.start();
            this.actual = outContent.toString();
            this.expected = this.testUtils.createRectangle();
            this.log();
            assertEquals(this.contains(), true);
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void testLineRectangleInvalidNumberOfArguments() {
        int w = 20;
        int h = 4;
        String data = "C " + w + " " + h + " \r";
        InputStream stdin = System.in;
        try {
            data = data.concat("R 14 1 18 ");
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            application.start();
            this.actual = outContent.toString();
            this.expected = "Invalid number of arguments. Rectangle creation input pattern : R x1<int>  y1<int> x2<int>  y2<int>";
            this.log();
            assertEquals(this.contains(), true);
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void testLineRectangleIllegalArgument() {
        int w = 20;
        int h = 4;
        String data = "C " + w + " " + h + " \r";
        InputStream stdin = System.in;
        try {
            data = data.concat("R 14 1 18 test");
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            application.start();
            this.actual = outContent.toString();
            this.expected = "Invalid argument type,expected Integer but found test Rectangle creation input pattern : R x1<int>  y1<int> x2<int>  y2<int>";
            this.log();
            assertEquals(this.contains(), true);
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void testBucketFill() {
        int w = 20;
        int h = 4;
        String data = "C " + w + " " + h + " \r";
        InputStream stdin = System.in;
        try {
            data = data.concat("L 1 2 6 2 \r");
            data = data.concat("L 6 3 6 4 \r");
            data = data.concat("R 14 1 18 3 \r");
            data = data.concat("B 10 3 o \r");
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            application.start();
            this.actual = outContent.toString();
            this.expected = this.testUtils.createBucketFill();
            this.log();
            assertEquals(this.contains(), true);
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    public void testQuit() {
        String data = "Q";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            application.start();
            this.actual = outContent.toString();
            this.expected = "Thanks for using the application,bye";
            this.log();
            assertEquals(this.contains(), true);
        } finally {
            System.setIn(stdin);
        }
    }

    private boolean contains() {
        return this.actual.contains(this.expected);
    }

    private void log() {
        System.setOut(sysOut);
        System.out.println("Actual :\n" + this.actual);
        System.out.println("******** Expected ****************");
        System.out.println(this.expected);
    }

}
