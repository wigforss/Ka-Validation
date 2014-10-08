package org.kasource.validation.date.impl;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.DateRange;


public class DateDateRangeValidator extends AbstractDateRangeValidator implements ConstraintValidator<DateRange, Date> {

    @Override
    public void initialize(DateRange annotation) {
        super.initialize(annotation);
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
       return isValid(value);
    }

}
