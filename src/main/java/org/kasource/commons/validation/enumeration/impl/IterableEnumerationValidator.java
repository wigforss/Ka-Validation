package org.kasource.commons.validation.enumeration.impl;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.enumeration.Enumeration;

public class IterableEnumerationValidator extends AbstractEnumerationValidator implements ConstraintValidator<Enumeration, Iterable<? extends Object>> {

    @Override
    public void initialize(Enumeration annotation) {
       super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        return isValidItarable(value);
    }

}
