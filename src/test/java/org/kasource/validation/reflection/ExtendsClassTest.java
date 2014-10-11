package org.kasource.validation.reflection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;


public class ExtendsClassTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void testExistingImplementingClass() {
        ClassRunner classRunner = new ClassRunner("java.lang.Thread");
        Set<ConstraintViolation<ClassRunner>> constraintViolations =
            validator.validate(classRunner);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void testNonExistingClass() {
        ClassRunner classRunner = new ClassRunner("dsadsa.adsdsa.Fjhkljdsa");
        Set<ConstraintViolation<ClassRunner>> constraintViolations =
            validator.validate(classRunner);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("must be a valid class that extends or implements [interface java.lang.Runnable]", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    private static class ClassRunner {
        @ExtendsClass(Runnable.class)
        private String className;

        public ClassRunner(String className) {
            this.className = className;
        }      
    }
}
