package org.kasource.validation.phone.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.phone.Phone;

public class PhoneValidator extends AbstractPhoneValidator implements ConstraintValidator<Phone, Object> {

    @Override
    public void initialize(Phone annotation) {
       super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return super.isValid(value);
        
    }
    
}
