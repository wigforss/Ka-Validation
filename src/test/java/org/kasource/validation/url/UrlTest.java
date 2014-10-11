package org.kasource.validation.url;

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



public class UrlTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void testGenericPhoneSuccess() {
        Contact contact = new Contact("http://mypage.com/me");
        Set<ConstraintViolation<Contact>> constraintViolations =
            validator.validate(contact);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void testInvalidGenericPhone() {
        Contact contact = new Contact("not a valid URL");
        Set<ConstraintViolation<Contact>> constraintViolations =
            validator.validate(contact);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid [http, https] URL", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    private static class Contact {
        @Url({"http", "https"})
        private String homepage;

        public Contact(String homepage) {     
            this.homepage = homepage;
        }
       
    }
}
