package com.cs.draw.validation;

import com.cs.draw.exception.ApplicationException;

public class ValidationResponse {

   private boolean valid;
   private String msg;

    public ValidationResponse(boolean valid) {
        this(valid,null);
    }

    public ValidationResponse(boolean valid, String msg) {
        this.valid = valid;
        this.msg=msg;
    }


    public String getMsg() {
        return msg;
    }

    public boolean isValid() {
        return valid;
    }


    public void then() throws ApplicationException{
        if(!this.valid)
             throw new ApplicationException(msg);
    }
}
