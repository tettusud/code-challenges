package com.cs.draw.builder;

import com.cs.draw.constants.CommandsEnum;
import com.cs.draw.constants.Input;
import com.cs.draw.exception.ApplicationException;
import com.cs.draw.patterns.*;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class PatternBuilder extends Builder {

    private Pattern pattern;
    @Override
    public Builder validate(String[] args) throws ApplicationException {
        this.pattern = Factory.getPattern(args[0], Arrays.asList(args).subList(1, args.length).toArray(new String[0]));
        Class cls=this.pattern.getClass();
        /* check if the input annotation is present on the Class */
        if (cls.isAnnotationPresent(Input.class)) {
            Annotation annotation = cls.getAnnotation(Input.class);
            Input inputInfo = (Input) annotation;
            //check for the size of the inputs ,if it doesnot match throw Exception
            if (this.pattern.getArgs().length != inputInfo.size()) {
                throw new ApplicationException("Invalid number of arguments. " + inputInfo.msg());
            }
        } else {
            throw new ApplicationException("Pattern info not configured, please check Input annotation for further details");
        }
        return this;
    }

    @Override
    public Pattern build() {
        return this.pattern;
    }

    private static class Factory {
        /**
         * @param pattern
         * @return
         * @throws ApplicationException
         */
        public static Pattern getPattern(String pattern, String[] params) throws ApplicationException {
            //to make it case insensitive
            pattern = pattern.toUpperCase();
            CommandsEnum patternEnum = CommandsEnum.fromString(pattern);
            switch (patternEnum) {
                case CANVAS:
                    return new Canvas(params);
                case RECTANGLE:
                    return new Rectangle(params);
                case LINE:
                    return new Line(params);
                case BUCKETFILL:
                    return new BucketFill(params);
                case QUIT:
                    return new BucketFill(params);
                case HELP:
                    return new BucketFill(params);
                default:
                    throw new ApplicationException("Unknown pattern :" + pattern);
            }
        }

    }


}
