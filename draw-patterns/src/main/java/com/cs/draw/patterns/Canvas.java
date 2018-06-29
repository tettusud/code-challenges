package com.cs.draw.patterns;


import com.cs.draw.constants.Input;
import com.cs.draw.exception.ApplicationException;
import com.cs.draw.processor.Context;

import java.util.ArrayList;

@Input(size=2 , msg = "Canvas creation input pattern : C width<int>  height<int> [eg: C 20 4 ]")
public class Canvas extends Pattern{

    private static final String HORIZONTAL_CHAR = "-";
    private static final String VERTICAL_CHAR = "|";

    //width w is x coord  ,  height h is y coord
    //canvas is hXb IE y X x
    private int h;
    private int w;

    public Canvas(String... args) throws ApplicationException{
        super(args);
        //first param is length
        this.w = Integer.parseInt(args[0]);
        //second param is breadth
        this.h = Integer.parseInt(args[1]);
    }

    @Override
    public void validate(Context context) throws ApplicationException {
        if(h<0 || w<0)
            throw new ApplicationException("Illegal Argument exception");
    }


    @Override
    public void build(Context context)  {
        //number of rows,cols in real sense is two more than entered
        //enclosing ares is supposed to by wXh
        this.h += 2;
        this.w += 2;


        String fill = "";
        //iterate row wise
        for (int i = 0; i < this.h; i++) {
            for (int j = 0; j < this.w; j++) {
                if (i == 0 || i == this.h - 1) {
                    fill = HORIZONTAL_CHAR;
                } else if (j == 0 || j == this.w - 1) {
                    fill = VERTICAL_CHAR;
                } else {
                    fill = " ";
                }
                context.getCtx()[i][j]=fill;
            }
        }
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }
}
