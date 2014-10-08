package org.kasource.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.DateRange;


public class DateRangeValidator extends AbstractDateRangeValidator implements ConstraintValidator<DateRange, String> {

    @Override
    public void initialize(DateRange annotation) {
        super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            return isValid(value);
        } catch (DateOutOfRangeException e) {
           setConstraintMessage(context, e.getRange());
           return false;
        }
    }

}
