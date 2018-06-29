package com.cs.draw.validation;

import com.cs.draw.constants.CommandsEnum;
import com.cs.draw.datactx.Command;

import java.util.function.Function;

/**
 *
 */
public interface CommandValidator extends Function<Command, ValidationResponse> {

    /***
     * Check if minimum of two inputs are passed or its not a valid input
     * @return
     */
    static CommandValidator validNumberOfCmdArgs() {
        return command -> {
            if( command.getArgs().length < 1){
                return new ValidationResponse(false,"Invalid Number of inputs");
            }
            return new ValidationResponse(true);

        };
    }

    /**
     * Check if the first character is a valid availalbe pattern
     *
     * @return
     */
    static CommandValidator isPatternAvailable() {
        return command -> {
            try {
                CommandsEnum.fromString(command.getArgs()[0]);
                return new ValidationResponse(true);
            } catch (IllegalArgumentException i) {
                return new ValidationResponse(false, i.getMessage());
            }
        };
    }

    static ValidationResponse validate(Command cmd){
        return validNumberOfCmdArgs().and(isPatternAvailable()).apply(cmd);
    }
    /***
     *  To "and" multiple conditionns
     * @param other
     * @return
     */
    default CommandValidator and(CommandValidator other) {
        return cmd ->{
            final ValidationResponse validationResponse= this.apply(cmd);
            return  validationResponse.isValid()? other.apply(cmd) : validationResponse;
        };
    }



}
