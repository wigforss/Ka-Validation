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


public class JavaClassTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void testExistingClass() {
        ClassRunner classRunner = new ClassRunner("java.lang.String");
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
        assertEquals("is not a valid class", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void testNotAnInterface() {
        ClassRunner2 classRunner = new ClassRunner2("java.lang.String");
        Set<ConstraintViolation<ClassRunner2>> constraintViolations =
            validator.validate(classRunner);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid Interface", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    private static class ClassRunner {
        @JavaClass
        private String className;

        public ClassRunner(String className) {
            this.className = className;
        }      
    }
    
    private static class ClassRunner2 {
        @JavaClass(JavaClassType.INTERFACE)
        private String className;

        public ClassRunner2(String className) {
            this.className = className;
        }      
    }
}
