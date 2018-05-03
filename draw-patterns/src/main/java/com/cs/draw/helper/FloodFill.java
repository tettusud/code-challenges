package com.cs.draw.helper;


import java.util.List;

/**
 * This is flood fill algoirthm used to fill the canvas.
 * Part of the Algorithm is copied from the web.
 */
public class FloodFill {

    /**
     * Recursively called until the expected area on canvas is drawn with the expected character
     *
     * @param data
     * @param colorToReplace
     * @param colorToPaint
     * @param x
     * @param y
     * @return
     * @throws ApplicationException
     */
    public List<List<String>> apply(List<List<String>> data, String colorToReplace, String colorToPaint, int x, int y) throws ApplicationException {
        validateData(data);

        String currentCoord = getValueAt(data, x, y);
        if (currentCoord == colorToReplace) {
            data.get(x).set(y, colorToPaint);
            apply(data, colorToReplace, colorToPaint, x + 1, y);
            apply(data, colorToReplace, colorToPaint, x - 1, y);
            apply(data, colorToReplace, colorToPaint, x, y + 1);
            apply(data, colorToReplace, colorToPaint, x, y - 1);
        }
        return data;
    }

    /**
     * Validate the data
     *
     * @param data
     * @throws ApplicationException
     */
    private void validateData(List<List<String>> data) throws ApplicationException {
        if (data == null) {
            throw new ApplicationException("You can't pass a null instance as picture");
        }
    }

    /**
     * Method created to avoid IndexOutOfBoundExceptions.
     * Make sure point is not selected beyond the canvas
     */
    private String getValueAt(List<List<String>> data, int x, int y) {
        if (x < 0 || y < 0 || x > data.size() || y > data.get(x).size()) {
            return "";
        } else {
            return data.get(x).get(y);
        }
    }
}
