package com.cs.draw;

import com.cs.draw.helper.ApplicationException;
import com.cs.draw.helper.PatternFactory;
import com.cs.draw.patterns.Pattern;

import java.util.Arrays;


/**
 * The {@code InputProcessor} class is used for processing the user input for creating a
 * pattern.
 * If the number of inputs are not valid or ,type of the input is wrong this class will
 * throw ApplicationException with appropriate message. *
 */
public class InputProcessor {

        /**
     * This method throws ApplicationException if invalid/wrong arguments are passed as command line input
     *
     * @return
     * @throws ApplicationException
     */
    public Pattern apply(String input) throws ApplicationException {
        if (input == null) {
            throw new ApplicationException("Not a valid input");
        }
        String[] inputs = input.split("\\s+");
        //checkif has inputs
        if(inputs.length<2){
            throw new ApplicationException("Not a valid input");
        }
        //get the pattern object corresponding to first input
        return PatternFactory.getPattern(inputs[0], Arrays.copyOfRange(inputs, 1, inputs.length));
    }
}
