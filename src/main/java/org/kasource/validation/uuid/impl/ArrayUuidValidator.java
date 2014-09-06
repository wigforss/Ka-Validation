package org.kasource.validation.uuid.impl;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.uuid.Uuid;

public class ArrayUuidValidator extends AbstractUuidValidator implements ConstraintValidator<Uuid, Object[]>{

    @Override
    public void initialize(Uuid annotation) {
        super.initialize(annotation);
    }
    
    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        return isValidArray(value);
    }

}
