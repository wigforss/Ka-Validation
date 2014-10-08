package org.kasource.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.DateFormat;

public class ArrayDateValidator extends AbstractDateTimeValidator implements ConstraintValidator<DateFormat, Object[]> {

    @Override
    public void initialize(DateFormat annotation) {
        super.initialize(annotation.value());
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        
        return isValidArray(value);
    }

}
