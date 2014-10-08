package org.kasource.validation.date.impl;

import java.util.Calendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.DateRange;


public class CalendarDateRangeValidator extends AbstractDateRangeValidator implements ConstraintValidator<DateRange, Calendar> {

    @Override
    public void initialize(DateRange annotation) {
        super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(Calendar value, ConstraintValidatorContext context) {
       return isValid(value);
    }

}
