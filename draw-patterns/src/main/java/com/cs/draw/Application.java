package com.cs.draw;

import com.cs.draw.processor.CommandProcessor;

import java.util.Scanner;

public class Application {


    /***
     * Entry point for the application
     * @param args
     */
    public static void main(String[] args){

        CommandProcessor processor=new CommandProcessor();
        // build the InputCommand
        // Validate the InputCommand check if c or l or enough arguments to qualify as n input
        // build the Pattern
        // Vlidate the input for the pattern
        // build the response
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            processor.process(scanner.nextLine());
        }
    }

}
