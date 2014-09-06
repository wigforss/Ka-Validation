package org.kasource.validation.checkdigit.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.checkdigit.Checkdigit;

public class CheckdigitValidator extends AbstractCheckdigitValidator implements ConstraintValidator<Checkdigit, String> {

    @Override
    public void initialize(Checkdigit annotation) {
        super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return super.isValid(value);
       
    }

}
