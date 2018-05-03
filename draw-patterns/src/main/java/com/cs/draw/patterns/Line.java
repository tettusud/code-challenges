package com.cs.draw.patterns;


import com.cs.draw.helper.ApplicationException;
import com.cs.draw.helper.Input;

import java.util.List;


/**
 * this class creates instance of Line pattern to draw on the canvas
 * <p>
 * L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
 * horizontal or vertical lines are supported. Horizontal and vertical lines
 * will be drawn using the 'x' character.
 */
@Input(
        inputSize = 4,
        types = {Input.Type.INT, Input.Type.INT, Input.Type.INT, Input.Type.INT},
        msg = "Line creation input pattern : L x1<int>  y1<int> x2<int>  y2<int> [eg: L 5 6 5 10]"
)
public class Line extends Pattern {

    private static final String DRAW_CHAR = "x";

    public Line(String[] params) {
        super(params);
    }

    @Override
    public List<List<String>> build(List<List<String>> data) throws ApplicationException {
        List<String> processingData = null;
        if (y[0] == y[1]) {
            processingData = data.get(y[0]);
            for (int i = x[0]; i <= x[1]; i++) {
                processingData.set(i, DRAW_CHAR);
            }
        } else if (x[0] == x[1]) {

            for (int i = y[0]; i <= y[1]; i++) {
                data.get(i).set(x[0], DRAW_CHAR);
            }
        }
        return data;
    }

    @Override
    public void processParams() {
        this.x=new Integer[]{Integer.parseInt(params[0]),Integer.parseInt(params[2])};
        this.y=new Integer[]{Integer.parseInt(params[1]),Integer.parseInt(params[3])};
    }

    /**
     * Validate if input is proper or not
     *
     * @throws ApplicationException
     */
    @Override
    public void validateParams(List<List<String>> data) throws ApplicationException {
        super.validateParams(data);
        if (this.x[0] != this.x[1] && this.y[0] != y[1]) {
            throw new ApplicationException("Currently only vertical or horizontal lines is supported");
        }
    }

}
