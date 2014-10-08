package org.kasource.validation.isbn.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.isbn.Isbn;

public class ArrayIsbnValidator extends AbstractIsbnValidator implements ConstraintValidator<Isbn, Object[]> {

   
    @Override
    public void initialize(Isbn constraintAnnotation) {     
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        return isValidArray(value);
    }

}
