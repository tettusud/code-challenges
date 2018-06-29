package com.cs.draw.processor;


import com.cs.draw.builder.PatternBuilder;
import com.cs.draw.exception.ApplicationException;
import com.cs.draw.datactx.Command;
import com.cs.draw.patterns.Canvas;
import com.cs.draw.patterns.Pattern;
import com.cs.draw.validation.CommandValidator;


public class CommandProcessor extends Context{

    public void process(String cmd){
        String[] args=cmd.split("\\s+");
        try{
            validateInput(args);
            Pattern pattern=build(args);

            //if canvas then initialize the contex
            if(pattern.getClass()== Canvas.class){
                initCtx(((Canvas)pattern).getH()+2,((Canvas)pattern).getW()+2);
            }else{
                if(getCtx()==null){
                    throw new ApplicationException("Looks like canvas is not initialized,please create canvas first");
                }
            }
            pattern.validate(this);
            pattern.build(this);
            //draw
            draw();
        }catch (ApplicationException ae){
            prompt(ae.getMessage());
        }
    }

    /**
     *   //validate the input
     * @param args
     * @throws ApplicationException
     */
    private void validateInput(String... args) throws ApplicationException {
        CommandValidator.validate(new Command(args)).then();
    }

    private Pattern build(String... args) throws ApplicationException {
       return new PatternBuilder().validate(args).build();
    }

    private void draw() throws ApplicationException {
        for (String[] cols : getCtx()) {
            System.out.println();
            for (String s : cols) {
                System.out.print(s);
            }
        }
        //create an empty new line
        System.out.println();
    }
    /**
     *
     * @param message
     */
    private void prompt(String message){
        System.out.println(message);
    }





}
