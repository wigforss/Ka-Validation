package org.kasource.commons.validation.enumeration.impl;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.enumeration.Enumeration;

public class ArrayEnumerationValidator extends AbstractEnumerationValidator implements ConstraintValidator<Enumeration, Object[]> {

    @Override
    public void initialize(Enumeration annotation) {
       super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        return isValidArray(value);
    }

}
