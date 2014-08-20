package org.kasource.commons.validation.creditcard;

import org.apache.commons.validator.routines.CodeValidator;
import org.apache.commons.validator.routines.CreditCardValidator;

public enum CardType {
    
     AMEX (CreditCardValidator.AMEX_VALIDATOR),
     DINERS (CreditCardValidator.DINERS_VALIDATOR),
     DISCOVER (CreditCardValidator.DISCOVER_VALIDATOR),
     MASTERCARD (CreditCardValidator.MASTERCARD_VALIDATOR),
     VISA (CreditCardValidator.VISA_VALIDATOR);
   
     private CodeValidator validator;
    
     CardType(CodeValidator validator) {
         this.validator = validator;
     }
     
     public CodeValidator getCodeValidator() {
         return validator;
     }
}
