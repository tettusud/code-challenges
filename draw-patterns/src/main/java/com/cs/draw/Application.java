package com.cs.draw;

import com.cs.draw.helper.ApplicationException;

import java.util.Scanner;


/**
 * Starting point of the DrawingService app challenge that was presented.
 */
public class Application {

    private static final String QUIT_CMD = "Q";
    private static final String HELP_CMD = "H";

    public static void main(String[] args) {
        help();
        Application application = new Application();
        application.start();
    }


    /**
     * Start capturing the input and process the input and draw to the console
     */
    public void start() {
        // create a scanner to read command line input
        Scanner scanner = new Scanner(System.in);
        prompt("enter command: ");
        DrawingService drawing = new DrawingService();
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            if (QUIT_CMD.equalsIgnoreCase(command)) {
                System.out.println("Thanks for using the application,bye.");
                break;
            } else if (HELP_CMD.equalsIgnoreCase(command)) {
                help();
            } else {
                try {
                    drawing.process(command);
                } catch (ApplicationException e) {
                    prompt(e.getMessage());
                } catch (IndexOutOfBoundsException ie) {
                    prompt(ie.getMessage());
                }
            }

            prompt("enter command: ");
        }
    }

    /**
     * prompt the user
     */
    private static void prompt(String prompt) {
        System.out.println(prompt);
    }

    private static void help() {
        prompt("");
        prompt("Welcome to DrawingService application");
        prompt("");
        prompt(" C  Canvas      [ C <width> <height> ]");
        prompt(" L  Line        [ L <x1> <y1> <x2> <y2> ]");
        prompt(" R  Rectangle   [ R <x1> <y1> <x2> <y2> ] ");
        prompt(" B  Bucket Fill [ B <x> <y> <c> ]");
        prompt(" Q  Quit        [ Q ]");
        prompt(" H  Help        [ H ]");
        prompt("");
        prompt(" x,y are coordinates on canvas, c is any character to fill");
        prompt("");
    }

}
