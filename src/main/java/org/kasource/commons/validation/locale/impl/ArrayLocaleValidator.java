package org.kasource.commons.validation.locale.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.locale.Locale;



public class ArrayLocaleValidator extends AbstractLocaleValidator implements ConstraintValidator<Locale, Object[]> {
 
    @Override
    public void initialize(Locale annotation) {
        super.initialize(annotation.caseSensetive());
    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {
      return isValidArray(value);
    }

}
