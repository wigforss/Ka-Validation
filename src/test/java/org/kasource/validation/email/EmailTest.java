package org.kasource.validation.email;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;


public class EmailTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void validEmail() {
        Contact conatct = new Contact("rikard.wigforss@example.com");
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(conatct);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void invalidEmail() {
        Contact conatct = new Contact("rikard.wigforss@example");
        
        Set<ConstraintViolation<Contact>> constraintViolations = validator.validate(conatct);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid email address", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    private static class Contact {
        @Email
        private String email;
        
        public Contact(String email) {
            this.email = email;
        }
    }
}
