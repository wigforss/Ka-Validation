package org.kasource.validation.locale.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.locale.Locale;



public class IterableLocaleValidator extends AbstractLocaleValidator implements ConstraintValidator<Locale, Iterable<? extends Object>> {
   
    @Override
    public void initialize(Locale annotation) {
        super.initialize(annotation.caseSensetive());
    }

    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        return isValidItarable(value);
    }

}
