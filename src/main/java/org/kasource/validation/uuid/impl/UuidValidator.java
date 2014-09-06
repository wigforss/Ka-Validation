package org.kasource.validation.uuid.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.uuid.Uuid;

public class UuidValidator extends AbstractUuidValidator implements ConstraintValidator<Uuid, String>{
 
    @Override
    public void initialize(Uuid annotation) {
       super.initialize(annotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return super.isValid(value);
    }

}
