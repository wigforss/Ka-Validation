package org.kasource.validation.reflection;

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
import org.junit.runner.RunWith;
import org.kasource.validation.reflection.impl.AnnotatedClassValidatorTest;


public class AnnotatedClassTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void testExistingImplementingClass() {
        TestClassRunner classRunner = new TestClassRunner(AnnotatedClassValidatorTest.class.getName());
        Set<ConstraintViolation<TestClassRunner>> constraintViolations =
            validator.validate(classRunner);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void testNonExistingClass() {
        TestClassRunner classRunner = new TestClassRunner("dsadsa.adsdsa.Fjhkljdsa");
        Set<ConstraintViolation<TestClassRunner>> constraintViolations =
            validator.validate(classRunner);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("must be a valid class annotated with [interface org.junit.runner.RunWith]", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    private static class TestClassRunner {
        @AnnotatedClass(RunWith.class)
        private String className;

        public TestClassRunner(String className) {
            this.className = className;
        }      
    }
}
