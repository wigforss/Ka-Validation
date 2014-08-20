package org.kasource.commons.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.date.Date;

public class ArrayDateValidator extends AbstractDateTimeValidator implements ConstraintValidator<Date, Object[]> {

    @Override
    public void initialize(Date annotation) {
        super.initialize(annotation.value());
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        
        return isValidArray(value);
    }

}
