package org.kasource.validation.reflection.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.reflection.ExtendsClass;


public class ExtendsClassValidator extends AbstractExtendsClassValidator implements ConstraintValidator<ExtendsClass, String> {

    @Override
    public void initialize(ExtendsClass annotation) {
      super.initialize(annotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return isValid(value);
    }

}
