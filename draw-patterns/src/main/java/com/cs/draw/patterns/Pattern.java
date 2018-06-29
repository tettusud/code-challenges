package com.cs.draw.patterns;

import com.cs.draw.exception.ApplicationException;
import com.cs.draw.processor.Context;

public abstract class Pattern {


    private String[] args;

    protected Integer[] x, y;

    public Pattern(String... args)  throws ApplicationException{
        this.args=args;

    }


    public abstract void validate(Context context)  throws ApplicationException;

    /**
     *
     */
    public abstract void build(Context context) throws ApplicationException;


    /**
     * @param data
     * @param point
     * @throws ApplicationException
     */
    protected void validateX(String[][] data, Integer... point) throws ApplicationException {
        validateCoordinates(data[0].length, point);
    }

    /**
     * @param data
     * @param point
     * @throws ApplicationException
     */
    protected void validateY(String[][] data, Integer... point) throws ApplicationException {
        validateCoordinates(data.length, point);
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


    protected void validateParams(String[][] data) throws ApplicationException {
        validateX(data,x);
        validateY(data,y);
    }


    public String[] getArgs() {
        return args;
    }



}
