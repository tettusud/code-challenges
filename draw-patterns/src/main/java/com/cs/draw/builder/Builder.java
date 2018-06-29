package com.cs.draw.builder;

import com.cs.draw.exception.ApplicationException;
import com.cs.draw.patterns.Pattern;

public abstract class Builder {

    /**
     *
     */
    public abstract Builder validate(String... args)  throws ApplicationException;

    /**
     *
     */
    public abstract Pattern build();



}
