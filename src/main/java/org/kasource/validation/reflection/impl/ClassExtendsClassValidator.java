package org.kasource.validation.reflection.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.reflection.ExtendsClass;


public class ClassExtendsClassValidator extends AbstractExtendsClassValidator implements ConstraintValidator<ExtendsClass, Class<?>> {

    @Override
    public void initialize(ExtendsClass annotation) {
      super.initialize(annotation);
    }

    @Override
    public boolean isValid(Class<?> value, ConstraintValidatorContext context) {
        return isValid(value);
    }

}
