package com.cs.draw.patterns;


import com.cs.draw.constants.Input;
import com.cs.draw.exception.ApplicationException;
import com.cs.draw.processor.Context;

/***
 * This class instance is created for DrawingService Rectangle pattern,with below inputs
 *
 * R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
 * lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
 * using the 'x' character.
 */
@Input(
        size = 4,
        msg = "Rectangle creation input pattern : R x1<int>  y1<int> x2<int>  y2<int> [eg: R 1 1 5 5]"
)
public class Rectangle extends Pattern{

    //character used to draw rectangle
    private static final String DRAW_CHAR = "x";

    public Rectangle(String... args) throws ApplicationException {
        super(args);
        this.x = new Integer[]{Integer.parseInt(args[0]), Integer.parseInt(args[2])};
        this.y = new Integer[]{Integer.parseInt(args[1]), Integer.parseInt(args[3])};
    }

    @Override
    public void validate(Context context) throws ApplicationException {
        super.validateParams(context.getCtx());
        if (x[1] <= x[0] || y[1] <= y[0]) {
            throw new ApplicationException("Rectangle cannot be drawn with the given inputs");
        }
    }

    @Override
    public void build(Context context) throws ApplicationException {
        //Clear the canvas for rectangle
        for (int i = y[0]; i <= y[1]; i++) {
            for (int j = x[0]; j <= x[1]; j++) {

                context.getCtx()[i][j]=" ";
            }
        }

        for (int i = y[0]; i <= y[1]; i++) {
            context.getCtx()[i][x[0]] = DRAW_CHAR;
            context.getCtx()[i][x[1]] = DRAW_CHAR;

        }
        for (int i = x[0]; i <= x[1]; i++) {
            context.getCtx()[y[0]][i] = DRAW_CHAR;
            context.getCtx()[y[1]][i] = DRAW_CHAR;
        }
    }


}
