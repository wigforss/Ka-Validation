package org.kasource.validation.reflection.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.reflection.ExtendsClass;


public class ArrayExtendsClassValidator extends AbstractExtendsClassValidator implements ConstraintValidator<ExtendsClass, Object[]> {

    @Override
    public void initialize(ExtendsClass annotation) {
      super.initialize(annotation);
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
        return isValidArray(value);
    }

}
