package org.kasource.validation.reflection.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.reflection.AnnotatedClass;


public class AnnotatedClassValidator extends AbstractAnnotatedClassValidator implements ConstraintValidator<AnnotatedClass, String> {

    @Override
    public void initialize(AnnotatedClass annotation) {
       super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isValid(value);
    }

}
