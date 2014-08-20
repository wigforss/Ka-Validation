package org.kasource.commons.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.date.Date;

public class IterableDateValidator extends AbstractDateTimeValidator implements ConstraintValidator<Date, Iterable<? extends Object>> {

    @Override
    public void initialize(Date annotation) {
        super.initialize(annotation.value());
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        
        return isValidItarable(value);
    }

}
