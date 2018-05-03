package com.cs.draw;

import com.cs.draw.helper.ApplicationException;
import com.cs.draw.helper.Input;
import com.cs.draw.patterns.Canvas;
import com.cs.draw.patterns.Pattern;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/***
 * Instances of the class {@code Class} used to call Input Processors and
 * draw the pattern on console
 *
 */
public class DrawingService {

    List<List<String>> data = null;

    /**
     * entry point for processing the input ,validating and drawing
     * @param input
     * @throws ApplicationException
     */
    public void process(String input) throws ApplicationException{
        InputProcessor inputProcessor = new InputProcessor();
        //check the input and prepare the pattern
        Pattern pattern= inputProcessor.apply(input);
        //validate the input for the class
        validate(pattern.getClass(),pattern.getParams());
        //if validation of the input succeeds process the inputs and update the fields
        pattern.processParams();
        //initialize the data
        if(pattern.getClass()==Canvas.class){
            //initialize the data
            data=new ArrayList<>();
        }else {
            //any other pattern thrown an error if canvas is not already intialized
            if(data==null){
                throw new ApplicationException("Looks like canvas is not initialized,please create canvas first");
            }
        }
        //call validate method on the pattern
        pattern.validateParams(data);
        //call the build method
        pattern.build(data);
        //draw the pattern now
        draw();
    }


    /***
     *
     * Validate the number of input parameters and type of parameters
     * @param cls Subclass that inherits Pattern
     * @param inputs
     */
    public void validate(Class<? extends Pattern> cls, String[] inputs) throws ApplicationException {
        //check if the input annotation is present on the Class
        if (cls.isAnnotationPresent(Input.class)) {
            Annotation annotation = cls.getAnnotation(Input.class);
            Input inputInfo = (Input) annotation;
            //check for the size of the inputs ,if it doenst match throw Exception
            if (inputs.length != inputInfo.inputSize()) {
                throw new ApplicationException("Invalid number of arguments. " + inputInfo.msg());
            }
            //check for the type of the input if mismatch throw error
            Input.Type[] types = inputInfo.types();
            for (int i = 0; i < inputs.length; i++) {
                if (types[i] == Input.Type.INT) {
                    try {
                        Integer.parseInt(inputs[i]);
                    } catch (Exception e) {
                        throw new ApplicationException("Invalid argument type,expected Integer but found " + inputs[i] + " " + inputInfo.msg());
                    }
                }
                //to be handled for other types in future
            }
        } else {
            throw new ApplicationException("Pattern info not configured, please check Input annotation for further details");
        }
    }


    /**
     *
     * @throws ApplicationException
     */
    private void draw() {
        for (List<String> cols : data) {
            System.out.println();
            for (String s : cols) {
                System.out.print(s);
            }
        }
        //create an empty new line
        System.out.println();
    }
}
