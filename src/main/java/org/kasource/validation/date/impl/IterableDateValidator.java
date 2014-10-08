package org.kasource.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.DateFormat;

public class IterableDateValidator extends AbstractDateTimeValidator implements ConstraintValidator<DateFormat, Iterable<? extends Object>> {

    @Override
    public void initialize(DateFormat annotation) {
        super.initialize(annotation.value());
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        
        return isValidItarable(value);
    }

}
