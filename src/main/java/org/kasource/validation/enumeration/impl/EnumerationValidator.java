package org.kasource.validation.enumeration.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.enumeration.Enumeration;


public class EnumerationValidator extends AbstractEnumerationValidator implements ConstraintValidator<Enumeration, String> {

    @Override
    public void initialize(final Enumeration enumeration) {
       super.initialize(enumeration);
     
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {            
        boolean isValid = isValid(value);
        if (!isValid) {
            setConstraintMessage(context);
        }
        return isValid;
    }

}
