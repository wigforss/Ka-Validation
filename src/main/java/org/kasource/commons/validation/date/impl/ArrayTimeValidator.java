package org.kasource.commons.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.date.Time;

public class ArrayTimeValidator extends AbstractDateTimeValidator implements ConstraintValidator<Time, Object[]> {

    @Override
    public void initialize(Time annotation) {
        super.initialize(annotation.value());
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        return isValidArray(value);
    }

}
