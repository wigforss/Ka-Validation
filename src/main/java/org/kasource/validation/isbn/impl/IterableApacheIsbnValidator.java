package org.kasource.validation.isbn.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.isbn.Isbn;

public class IterableApacheIsbnValidator extends AbstractIsbnValidator implements ConstraintValidator<Isbn, Iterable<? extends Object>> {

   
    @Override
    public void initialize(Isbn constraintAnnotation) {     
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        return isValidItarable(value);
    }

}
