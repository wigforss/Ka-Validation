package org.kasource.commons.validation.locale;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class LocaleTest {
    
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void test() {
        MyClass object = new MyClass("en-US");
        Set<ConstraintViolation<MyClass>> constraintViolations =
            validator.validate(object);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void testNegative() {
        MyClass object = new MyClass("bu-LL");
        Set<ConstraintViolation<MyClass>> constraintViolations =
            validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
    }
    
    @Test
    public void testIteratable() {
        MyClass2 object = new MyClass2("en-US", "sv-SE");
        Set<ConstraintViolation<MyClass2>> constraintViolations =
            validator.validate(object);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void testIteratableNegative() {
        MyClass2 object = new MyClass2("bu-LL");
        Set<ConstraintViolation<MyClass2>> constraintViolations =
            validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
    }
    
    @Test
    public void testIteratableNegative2() {
        MyClass2 object = new MyClass2("en-US", "sv-SE", "bu-LL");
        Set<ConstraintViolation<MyClass2>> constraintViolations =
            validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
    }
    
    @Test
    public void testArray() {
        MyClass3 object = new MyClass3("en-US", "sv-SE");
        Set<ConstraintViolation<MyClass3>> constraintViolations =
            validator.validate(object);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void testArrayNullElement() {
        MyClass3 object = new MyClass3("en-US", null, "sv-SE");
        Set<ConstraintViolation<MyClass3>> constraintViolations =
            validator.validate(object);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void testArrayNegative() {
        MyClass3 object = new MyClass3("bu-LL");
        Set<ConstraintViolation<MyClass3>> constraintViolations =
            validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
    }
    
    private static final class MyClass {
        @Locale
        private String locale;
        
        public MyClass(String locale) {
            this.locale = locale;
        }
    }
    
    private static final class MyClass2 {
        @Locale
        private List<String> locale;
        
        public MyClass2(String... locale) {
            this.locale = Arrays.asList(locale);
        }
    }
    
    private static final class MyClass3 {
        @Locale
        private String[] locale;
        
        public MyClass3(String... locale) {
            this.locale = locale;
        }
    }
}
