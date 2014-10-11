package org.kasource.validation.reflection.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.reflection.AnnotatedClass;


public class IterableAnnotatedClassValidator extends AbstractAnnotatedClassValidator implements ConstraintValidator<AnnotatedClass, Iterable<? extends Object>> {

    @Override
    public void initialize(AnnotatedClass annotation) {
       super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        return isValidItarable(value);
    }

}
