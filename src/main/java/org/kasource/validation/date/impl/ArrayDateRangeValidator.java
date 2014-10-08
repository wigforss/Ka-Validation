package org.kasource.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.DateRange;


public class ArrayDateRangeValidator extends AbstractDateRangeValidator implements ConstraintValidator<DateRange, Object[]> {

    @Override
    public void initialize(DateRange annotation) {
        super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
       return isValidArray(value);
    }

}
