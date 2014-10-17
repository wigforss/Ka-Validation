package org.kasource.validation.date.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.date.DateRange;


public class IterableDateRangeValidator extends AbstractDateRangeValidator implements ConstraintValidator<DateRange, Iterable<? extends Object>> {

    @Override
    public void initialize(DateRange annotation) {
        super.initialize(annotation);  
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
       try {
           return isValidItarable(value);
       } catch (DateOutOfRangeException e) {
          setConstraintMessage(context, e.getRange());
          return false;
       }
    }

}
