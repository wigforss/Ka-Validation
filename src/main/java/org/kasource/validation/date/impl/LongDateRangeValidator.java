package org.kasource.validation.date.impl;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.DateRange;


public class LongDateRangeValidator extends AbstractDateRangeValidator implements ConstraintValidator<DateRange, Long> {

    @Override
    public void initialize(DateRange annotation) {
        super.initialize(annotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
       return isValid(value);
    }

}
