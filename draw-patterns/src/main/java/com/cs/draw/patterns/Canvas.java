package com.cs.draw.patterns;


import com.cs.draw.helper.ApplicationException;
import com.cs.draw.helper.Input;

import java.util.ArrayList;
import java.util.List;

/***
 * To draw canvas
 * Pattern to create canvas is,
 * C w h           Should create a new canvas of width w and height h.
 *
 *  construct a canvas data of  bXh
 *   so outer list is h in size
 *   inner list is b in size
 */

@Input(
        inputSize = 2,
        types = {Input.Type.INT, Input.Type.INT},
        msg = "Canvas creation input pattern : C width<int>  height<int> [eg: C 20 4 ]"
)
public class Canvas extends Pattern {

    private static final String HORIZONTAL_CHAR = "-";
    private static final String VERTICAL_CHAR = "|";

    //width w is x coord  ,  height h is y coord
    //canvas is hXb IE y X x
    private int h;
    private int w;

    public Canvas(String[] params) {
        super(params);
    }

    /**
     * C w h           Should fill a new canvas of width w and height h.
     *
     * @param data
     */
    @Override
    public List<List<String>> build(List<List<String>> data) {

        //number of rows,cols in real sense is two more than entered
        //enclosing ares is supposed to by wXh
        this.h += 2;
        this.w += 2;

        //init row/height wise, along y axis
        for (int i = 0; i < this.h; i++) {
            data.add(new ArrayList<>(this.w));
        }
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
                data.get(i).add(fill);
            }
        }
        return data;
    }

    @Override
    public void processParams() {
        //first param is length
        this.w = Integer.parseInt(params[0]);
        //second param is breadth
        this.h = Integer.parseInt(params[1]);
    }

    @Override
    public void validateParams(List<List<String>> data)  {
        //nothing to validate
    }


}
