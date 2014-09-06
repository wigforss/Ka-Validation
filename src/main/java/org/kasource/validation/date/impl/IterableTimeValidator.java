package org.kasource.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.TimeFormat;

public class IterableTimeValidator extends AbstractDateTimeValidator implements ConstraintValidator<TimeFormat, Iterable<? extends Object>> {

    @Override
    public void initialize(TimeFormat annotation) {
        super.initialize(annotation.value());
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        return isValidItarable(value);
    }

}
