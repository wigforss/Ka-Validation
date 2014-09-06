package org.kasource.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.TimeFormat;

public class ArrayTimeValidator extends AbstractDateTimeValidator implements ConstraintValidator<TimeFormat, Object[]> {

    @Override
    public void initialize(TimeFormat annotation) {
        super.initialize(annotation.value());
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        return isValidArray(value);
    }

}
