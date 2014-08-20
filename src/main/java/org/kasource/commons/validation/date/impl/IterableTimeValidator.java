package org.kasource.commons.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.date.Time;

public class IterableTimeValidator extends AbstractDateTimeValidator implements ConstraintValidator<Time, Iterable<? extends Object>> {

    @Override
    public void initialize(Time annotation) {
        super.initialize(annotation.value());
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        return isValidItarable(value);
    }

}
