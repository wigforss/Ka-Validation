package org.kasource.validation.xml;

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
import org.kasource.validation.xml.impl.note.Note;


public class JaxbTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void testGenericPhoneSuccess() {
        Notes notes = new Notes("classpath:/org/kasource/validation/xml/impl/test-note-ns.xml");
        Set<ConstraintViolation<Notes>> constraintViolations =
            validator.validate(notes);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void testInvalidGenericPhone() {
        Notes notes = new Notes("classpath:/org/kasource/validation/xml/impl/test-note-ns-broken.xml");
        Set<ConstraintViolation<Notes>> constraintViolations =
            validator.validate(notes);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("could not parse XML as class org.kasource.validation.xml.impl.note.Note", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    private static class Notes {
        @Jaxb(Note.class)
        private String note;

        public Notes(String note) {
            this.note = note;
        }
    
    }
}
