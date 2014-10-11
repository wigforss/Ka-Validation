package org.kasource.validation.uuid;

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


public class UuidTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void testGenericPhoneSuccess() {
        Request request = new Request("f47ac10b-58cc-4372-a567-0e02b2c3d479");
        Set<ConstraintViolation<Request>> constraintViolations =
            validator.validate(request);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void testInvalidGenericPhone() {
        Request request = new Request("not a valid UUID");
        Set<ConstraintViolation<Request>> constraintViolations =
            validator.validate(request);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid UUID", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    private static class Request {
        @Uuid
        private String requestUuid;

        public Request(String requestUuid) {
            this.requestUuid = requestUuid;
        }

    }
}
