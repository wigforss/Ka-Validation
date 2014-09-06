package org.kasource.validation.phone.impl;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.phone.Phone;

public class IterablePhoneValidator extends AbstractPhoneValidator implements ConstraintValidator<Phone, Iterable<? extends Object>> {

    @Override
    public void initialize(Phone annotation) {
       super.initialize(annotation);
        
    }
    
    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {
        return isValidItarable(value);
    }

   

}
