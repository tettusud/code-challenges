package com.cs.draw.patterns;

import com.cs.draw.InputBuilderService;
import com.cs.draw.helper.ApplicationException;

import java.util.List;

/***
 * This class must be extended by all the Pattern specific classes.
 * This class validates and handles some common task for processing the Pattern objects
 */
public abstract class Pattern implements InputBuilderService {

    Integer[] x, y;

    //all the inputs for drawing a particular pattern
    protected String[] params;

    public Pattern(String[] params) {
        this.params = params;
    }

    /**
     * @param data
     * @param point
     * @throws ApplicationException
     */
    protected void validateX(List<List<String>> data, Integer... point) throws ApplicationException {
        validateCoordinates(data.get(0).size(), point);
    }

    /**
     * @param data
     * @param point
     * @throws ApplicationException
     */
    protected void validateY(List<List<String>> data, Integer... point) throws ApplicationException {
        validateCoordinates(data.size(), point);
    }

    /**
     * Validate if the given inputs are within the coordinates or not
     *
     * @param max
     * @param point
     * @throws ApplicationException
     */
    private void validateCoordinates(Integer max, Integer... point) throws ApplicationException {
        for (int point1 : point) {
            if (point1 > max - 2 || point1 < 1) {
                throw new ApplicationException("Arguments are outside the canvas,please provide valid input ");
            }
        }
    }


    @Override
    public void validateParams(List<List<String>> data) throws ApplicationException {
        validateX(data,x);
        validateY(data,y);
    }

    public String[] getParams() {
        return params;
    }
}
