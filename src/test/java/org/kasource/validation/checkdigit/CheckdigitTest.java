package org.kasource.validation.checkdigit;

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



public class CheckdigitTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void testIsbnOK() {
        Book object = new Book("91-32-33268-8", "502073-8455");
        Set<ConstraintViolation<Book>> constraintViolations =
            validator.validate(object);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void testIsbnFails() {
        Book object = new Book("91-32-33268-7", "502073-8455");
        Set<ConstraintViolation<Book>> constraintViolations =
            validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid ISBN value", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void luhnTest() {
        Book object = new Book("91-32-33268-8", "502073-8455");
        Set<ConstraintViolation<Book>> constraintViolations =
            validator.validate(object);
        assertTrue(constraintViolations.isEmpty());
    
    }
    
    @Test
    public void luhnInvalidTest() {
        Book object = new Book("91-32-33268-8", "19502073-8455");
        Set<ConstraintViolation<Book>> constraintViolations =
            validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid Luhn value", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    private static final class Book {
        @SuppressWarnings("unused")
        @Checkdigit(Algorithm.ISBN)
        private String isbn;
        
        @SuppressWarnings("unused")
        @Checkdigit(Algorithm.LUHN)
        private String authorId;
        
        public Book(String isbn, String authorId) {
            this.isbn = isbn;
            this.authorId = authorId;
        }
    }
}
