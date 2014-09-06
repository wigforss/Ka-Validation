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
    public void testVisaFailed() {
        Purchase object = new Purchase("24343243");
        Set<ConstraintViolation<Purchase>> constraintViolations =
            validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid [VISA, MASTERCARD] credit card number", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    private static final class Purchase {
        @CreditCard({CardType.VISA, CardType.MASTERCARD})
        private String creditCard;
        
        public Purchase(String creditCard) {
            this.creditCard = creditCard;
        }
    }
}
