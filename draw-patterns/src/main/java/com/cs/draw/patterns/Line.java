package com.cs.draw.patterns;


import com.cs.draw.constants.Input;
import com.cs.draw.exception.ApplicationException;
import com.cs.draw.processor.Context;

/**
 * this class creates instance of Line pattern to draw on the canvas
 * <p>
 * L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
 * horizontal or vertical lines are supported. Horizontal and vertical lines
 * will be drawn using the 'x' character.
 */
@Input(size = 4, msg = "Line creation input pattern : L x1<int>  y1<int> x2<int>  y2<int> [eg: L 5 6 5 10]")
public class Line extends Pattern {

    private static final String DRAW_CHAR = "x";



    public Line(String... args) throws ApplicationException {
        super(args);
        this.x = new Integer[]{Integer.parseInt(args[0]), Integer.parseInt(args[2])};
        this.y = new Integer[]{Integer.parseInt(args[1]), Integer.parseInt(args[3])};
    }

    @Override
    public void validate(Context context) throws ApplicationException {
        super.validateParams(context.getCtx());
        if (this.x[0] != this.x[1] && this.y[0] != y[1]) {
            throw new ApplicationException("Currently only vertical or horizontal lines is supported");
        }
    }

    @Override
    public void build(Context context) throws ApplicationException {


        String[] processingData = null;

        if (y[0] == y[1]) {
            processingData = context.getCtx()[y[0]];
            for (int i = x[0]; i <= x[1]; i++) {
                processingData[i]= DRAW_CHAR;
            }
        } else if (x[0] == x[1]) {
            for (int i = y[0]; i <= y[1]; i++) {
                context.getCtx()[i][x[0]]= DRAW_CHAR;
            }
        }

    }


}
