package org.kasource.commons.validation.url.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


import org.kasource.commons.validation.url.Url;

public class ArrayUrlValidator extends AbstractUrlValidator implements ConstraintValidator<Url, Object[]> {

    @Override
    public void initialize(Url annotation) {
       super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        return isValidArray(value);
    }

}
