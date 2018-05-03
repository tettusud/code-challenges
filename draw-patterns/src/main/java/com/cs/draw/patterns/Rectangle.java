package com.cs.draw.patterns;

import com.cs.draw.helper.ApplicationException;
import com.cs.draw.helper.Input;

import java.util.List;

/***
 * This class instance is created for DrawingService Rectangle pattern,with below inputs
 *
 * R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
 * lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
 * using the 'x' character.
 */
@Input(
        inputSize = 4,
        types = {Input.Type.INT, Input.Type.INT, Input.Type.INT, Input.Type.INT},
        msg = "Rectangle creation input pattern : R x1<int>  y1<int> x2<int>  y2<int> [eg: R 1 1 5 5]"
)
public class Rectangle extends Pattern {
    //character used to draw rectangle
    private static final String DRAW_CHAR = "x";

    public Rectangle(String[] params){
        super(params);
    }

    @Override
    public List<List<String>> build(List<List<String>> data) {
        //Clear the canvas for rectangle
        for (int i = y[0]; i <= y[1]; i++) {
            for (int j = x[0]; j <= x[1]; j++) {
                data.get(i).set(j, " ");
            }
        }

        for (int i = y[0]; i <= y[1]; i++) {
            data.get(i).set(x[0], DRAW_CHAR);
            data.get(i).set(x[1], DRAW_CHAR);
        }
        for (int i = x[0]; i <= x[1]; i++) {
            data.get(y[0]).set(i, DRAW_CHAR);
            data.get(y[1]).set(i, DRAW_CHAR);
        }
        return data;
    }

    @Override
    public void processParams() {
        this.x=new Integer[]{Integer.parseInt(params[0]),Integer.parseInt(params[2])};
        this.y=new Integer[]{Integer.parseInt(params[1]),Integer.parseInt(params[3])};
    }

    @Override
    public void validateParams(List<List<String>> data) throws ApplicationException {
        super.validateParams(data);
        if (x[1] <= x[0] || y[1] <= y[0]) {
            throw new ApplicationException("Rectangle cannot be drawn with the given inputs");
        }
    }
}
