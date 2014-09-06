package org.kasource.validation.date.impl;

import java.util.concurrent.TimeUnit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.DateFormat;

public class ArrayDateValidator extends AbstractDateTimeValidator implements ConstraintValidator<DateFormat, Object[]> {

    @Override
    public void initialize(DateFormat annotation) {
        super.initialize(annotation.value(), annotation.rangeCheck(), annotation.offset(), annotation.before(), annotation.after(), TimeUnit.DAYS, true);
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        
        return isValidArray(value);
    }

}
