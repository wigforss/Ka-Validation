package org.kasource.commons.validation.checkdigit.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.checkdigit.Checkdigit;

public class NumberCheckdigitValidator extends AbstractCheckdigitValidator implements ConstraintValidator<Checkdigit, Number> {

    @Override
    public void initialize(Checkdigit annotation) {
        super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        return isValid(value);
    }

}
