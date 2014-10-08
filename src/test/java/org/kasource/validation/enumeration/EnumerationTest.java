package org.kasource.validation.enumeration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;


public class EnumerationTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void validEnumValueTest() {
        ScheduledTask task = new ScheduledTask("SECONDS");
        Set<ConstraintViolation<ScheduledTask>> constraintViolations = validator.validate(task);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void invalidEnumValueTest() {
        ScheduledTask task = new ScheduledTask("SE");
        Set<ConstraintViolation<ScheduledTask>> constraintViolations = validator.validate(task);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid time unit, valid values are [NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS]", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    private class ScheduledTask {
        @Enumeration(value = TimeUnit.class, enumMessageKey="java.util.concurrent.TimeUnit")
        private String timeUnit;
        
        public ScheduledTask(String timeUnit) {
            this.timeUnit = timeUnit;
        }
    }
}
