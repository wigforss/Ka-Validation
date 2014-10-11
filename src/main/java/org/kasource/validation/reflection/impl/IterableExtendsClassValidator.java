package org.kasource.validation.reflection.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.reflection.ExtendsClass;


public class IterableExtendsClassValidator extends AbstractExtendsClassValidator implements ConstraintValidator<ExtendsClass, Iterable<? extends Object>> {

    @Override
    public void initialize(ExtendsClass annotation) {
      super.initialize(annotation);
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        return isValidItarable(value);
    }

}
