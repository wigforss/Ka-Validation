package org.kasource.validation.creditcard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;


public class CreditCardTest {
    private static final String VISA = "4012888888881881";
    
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void testVisa() {
        Purchase object = new Purchase(VISA);
        Set<ConstraintViolation<Purchase>> constraintViolations =
            validator.validate(object);
        assertTrue(constraintViolations.isEmpty());
      
    }
    
    @Test
    public void testVisaOrMasterCardFailed() {
        Purchase object = new Purchase("24343243");
        Set<ConstraintViolation<Purchase>> constraintViolations =
            validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid Visa or MasterCard credit card number", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void testVisaFailed() {
        PurchaseVisa object = new PurchaseVisa("24343243");
        Set<ConstraintViolation<PurchaseVisa>> constraintViolations =
            validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid Visa credit card number", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void test3CardTypesFailed() {
        PurchaseVisaMasterCardAmex object = new PurchaseVisaMasterCardAmex("24343243");
        Set<ConstraintViolation<PurchaseVisaMasterCardAmex>> constraintViolations =
            validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid Visa, MasterCard or American Express credit card number", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void testAnyCardTypeFailed() {
        PurchaseAnyCard object = new PurchaseAnyCard("24343243");
        Set<ConstraintViolation<PurchaseAnyCard>> constraintViolations =
            validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid credit card number", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    
    private static final class PurchaseAnyCard {
        @CreditCard
        private String creditCard;
        
        public PurchaseAnyCard(String creditCard) {
            this.creditCard = creditCard;
        }
    }
    
    private static final class PurchaseVisa {
        @CreditCard(CardType.VISA)
        private String creditCard;
        
        public PurchaseVisa(String creditCard) {
            this.creditCard = creditCard;
        }
    }
    
    private static final class PurchaseVisaMasterCardAmex {
        @CreditCard({CardType.VISA, CardType.MASTERCARD, CardType.AMEX})
        private String creditCard;
        
        public PurchaseVisaMasterCardAmex(String creditCard) {
            this.creditCard = creditCard;
        }
    }
    
    private static final class Purchase {
        @CreditCard({CardType.VISA, CardType.MASTERCARD})
        private String creditCard;
        
        public Purchase(String creditCard) {
            this.creditCard = creditCard;
        }
    }
}
