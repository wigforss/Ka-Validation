package org.kasource.commons.validation.isbn.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.isbn.Isbn;

public class ArrayApacheIsbnValidator extends AbstractIsbnValidator implements ConstraintValidator<Isbn, Object[]> {

   
    @Override
    public void initialize(Isbn constraintAnnotation) {     
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        return isValidArray(value);
    }

}
