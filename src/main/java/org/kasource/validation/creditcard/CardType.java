package org.kasource.validation.creditcard;

import org.apache.commons.validator.routines.CodeValidator;
import org.apache.commons.validator.routines.CreditCardValidator;

public enum CardType {
    
     AMEX (CreditCardValidator.AMEX_VALIDATOR, "American Express"),
     DINERS (CreditCardValidator.DINERS_VALIDATOR, "Diners"),
     DISCOVER (CreditCardValidator.DISCOVER_VALIDATOR, "Discover"),
     MASTERCARD (CreditCardValidator.MASTERCARD_VALIDATOR, "Master Card"),
     VISA (CreditCardValidator.VISA_VALIDATOR, "Visa");
   
     private CodeValidator validator;
     private String cardTypeName;
     
     CardType(CodeValidator validator, String cardTypeName) {
         this.validator = validator;
         this.cardTypeName = cardTypeName;
     }
     
     public CodeValidator getCodeValidator() {
         return validator;
     }

    /**
     * @return the cardTypeName
     */
    public String getCardTypeName() {
        return cardTypeName;
    }
}
