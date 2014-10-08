package org.kasource.validation.enumeration.impl;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.enumeration.Enumeration;

public class ArrayEnumerationValidator extends AbstractEnumerationValidator implements ConstraintValidator<Enumeration, Object[]> {

    @Override
    public void initialize(Enumeration annotation) {
       super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        boolean isValid = isValidArray(value);
        if (!isValid) {
            setConstraintMessage(context);
        }
        return isValid;
    }

}
