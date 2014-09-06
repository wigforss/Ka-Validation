package org.kasource.validation.creditcard.impl;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.creditcard.CreditCard;


public class CreditCardValidator extends AbstractCreditCardValidator implements ConstraintValidator<CreditCard, String> {

  
    
    @Override
    public void initialize(CreditCard annotation) {
        super.initialize(annotation);
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        
        return isValid(value);
    }

}
