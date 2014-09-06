package org.kasource.validation.creditcard.impl;



import org.apache.commons.validator.routines.CodeValidator;
import org.apache.commons.validator.routines.CreditCardValidator;
import org.kasource.validation.AbstractValidator;
import org.kasource.validation.creditcard.CardType;
import org.kasource.validation.creditcard.CreditCard;


public class AbstractCreditCardValidator extends AbstractValidator {

    private CreditCardValidator creditCardValidator;
    
  
    protected void initialize(CreditCard annotation) {
        CardType[] cardTypes = annotation.value();
        if (cardTypes.length == 0) {
            creditCardValidator = new CreditCardValidator(CreditCardValidator.AMEX 
                                                          + CreditCardValidator.DINERS 
                                                          + CreditCardValidator.DISCOVER 
                                                          + CreditCardValidator.MASTERCARD 
                                                          + CreditCardValidator.VISA);
        } else {
            CodeValidator[] codeValidators = new CodeValidator[cardTypes.length];
            for (int i = 0 ; i < cardTypes.length; i++) {
                codeValidators[i] = annotation.value()[i].getCodeValidator();
            }
            creditCardValidator = new CreditCardValidator(codeValidators);
        }
        
    }

    @Override
    protected boolean isValid(Object value) {
        if (value == null) {
            return true;
        }
        return creditCardValidator.isValid(value.toString());
    }

}
