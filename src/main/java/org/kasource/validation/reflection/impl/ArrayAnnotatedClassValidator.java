package org.kasource.validation.reflection.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.reflection.AnnotatedClass;


public class ArrayAnnotatedClassValidator extends AbstractAnnotatedClassValidator implements ConstraintValidator<AnnotatedClass, Object[]> {

    @Override
    public void initialize(AnnotatedClass annotation) {
       super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        return isValidArray(value);
    }

}
