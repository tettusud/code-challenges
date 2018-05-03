package com.cs.draw.helper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * A program element annotated with Input is configured to provide details about the input
 * required to create required shapes pattern.
 * <p>
 * Annote the Pattern class with the details in order to automatically handle the error
 * and configure error message
 * <p>
 * For example details check com.cs.drwa.patterns.Canvas
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //on class level
public @interface Input {
    /**
     * number of inputs for a particular shape
     *
     * @return
     */
    public int inputSize();

    /**
     * type of input for a specific pattern whether int or string
     *
     * @return
     */
    public Type[] types();


    public enum Type {
        INT, STRING
    }

    /**
     * Hint message to show when user enters wrong/invalid arguments
     *
     * @return
     */
    public String msg();
}
