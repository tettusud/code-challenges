package com.cs.draw;

import com.cs.draw.helper.ApplicationException;

import java.util.List;

public interface InputBuilderService {

    /**
     * update the params
     */
     void processParams() ;

    /**
     *  Validate the input is valid for individual pattern or not
     */
     void validateParams(List<List<String>> data) throws ApplicationException;


    /**
     *  build the logic for drawing the pattern
     */
     List<List<String>> build(List<List<String>> data) throws ApplicationException;


}
