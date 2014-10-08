package org.kasource.validation.isbn.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.isbn.Isbn;

public class IsbnValidator extends AbstractIsbnValidator implements ConstraintValidator<Isbn, String>{

   
    
    @Override
    public void initialize(Isbn constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
       return isValid(value);
        
    }

}
