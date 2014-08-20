package org.kasource.commons.validation.url.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import org.kasource.commons.validation.url.Url;

public class IterableUrlValidator extends AbstractUrlValidator implements ConstraintValidator<Url, Iterable<? extends Object>> {

    @Override
    public void initialize(Url annotation) {
       super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        return isValidItarable(value);
    }

}
