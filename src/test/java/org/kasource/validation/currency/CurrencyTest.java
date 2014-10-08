package org.kasource.validation.currency;

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



public class CurrencyTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void testUSD() {
        Purchase object = new Purchase("USD");
        Set<ConstraintViolation<Purchase>> constraintViolations =
            validator.validate(object);
        assertTrue(constraintViolations.isEmpty());
      
    }
    
    @Test
    public void testUnkwnon() {
        Purchase object = new Purchase("24343243");
        Set<ConstraintViolation<Purchase>> constraintViolations =
            validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid currency code", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void testSEK() {
        ScandinavianPurchase object = new ScandinavianPurchase("SEK");
        Set<ConstraintViolation<ScandinavianPurchase>> constraintViolations =
            validator.validate(object);
        assertTrue(constraintViolations.isEmpty());
      
    }
    
    @Test
    public void testNonScandinavian() {
        ScandinavianPurchase object = new ScandinavianPurchase("USD");
        Set<ConstraintViolation<ScandinavianPurchase>> constraintViolations =
            validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid currency code only [SEK, NOK, DKK] is allowed", 
                    constraintViolations.iterator().next().getMessage());
      
    }
    
    @Test
    public void testNonSwedish() {
        SwedishPurchase object = new SwedishPurchase("USD");
        Set<ConstraintViolation<SwedishPurchase>> constraintViolations =
            validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid currency code only SEK is allowed", 
                    constraintViolations.iterator().next().getMessage());
      
    }
    
    
    private static final class Purchase {
        @Currency
        private String currency;
        
        public Purchase(String currency) {
            this.currency = currency;
        }
    }
    
    private static final class SwedishPurchase {
        @Currency(CurrencyCode.SEK)
        private String currency;
        
        public SwedishPurchase(String currency) {
            this.currency = currency;
        }
    }
    
    
    private static final class ScandinavianPurchase {
        @Currency({CurrencyCode.SEK, CurrencyCode.NOK, CurrencyCode.DKK})
        private String currency;
        
        public ScandinavianPurchase(String currency) {
            this.currency = currency;
        }
    }
}
