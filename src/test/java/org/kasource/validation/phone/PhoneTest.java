package org.kasource.validation.phone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;


public class PhoneTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void testGenericPhoneSuccess() {
        Contact contact = new Contact("24243554");
        Set<ConstraintViolation<Contact>> constraintViolations =
            validator.validate(contact);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void testInvalidGenericPhone() {
        Contact contact = new Contact("2424xzc3554");
        Set<ConstraintViolation<Contact>> constraintViolations =
            validator.validate(contact);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid phone number", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void testSwedishPhoneSuccess() {
        SwedishContact contact = new SwedishContact("08-323 42 34");
        Set<ConstraintViolation<SwedishContact>> constraintViolations =
            validator.validate(contact);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void testInvalidSwedishPhone() {
        String countryName = new Locale("", "SE").getDisplayCountry(Locale.getDefault());
        
        SwedishContact contact = new SwedishContact("2424xzc3554");
        Set<ConstraintViolation<SwedishContact>> constraintViolations =
            validator.validate(contact);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid phone number for " + countryName, 
                    constraintViolations.iterator().next().getMessage());
    }
    
    private static class Contact {
        @Phone
        private String phone;

        public Contact(String phone) {
            super();
            this.phone = phone;
        }
       
    }
    
    private static class SwedishContact {
        @Phone(country="SE")
        private String phone;
        
        public SwedishContact(String phone) {
            super();
            this.phone = phone;
        }
    }
}
