package org.kasource.commons.validation.uuid.impl;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.uuid.Uuid;

public class IterableUuidValidator extends AbstractUuidValidator implements ConstraintValidator<Uuid, Iterable<? extends Object>>{

    @Override
    public void initialize(Uuid annotation) {
        super.initialize(annotation);
    }
    
    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        return isValidItarable(value);
    }

}
