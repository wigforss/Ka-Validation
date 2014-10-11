package org.kasource.validation.reflection.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.reflection.AnnotatedClass;


public class ClassAnnotatedClassValidator extends AbstractAnnotatedClassValidator implements ConstraintValidator<AnnotatedClass, Class<?>> {

    @Override
    public void initialize(AnnotatedClass annotation) {
       super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(Class<?> value, ConstraintValidatorContext context) {
        return isValid(value);
    }

}
