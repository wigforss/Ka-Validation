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


public class XmlTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void testXmlSuccess() {
        Configuration config = new Configuration("classpath:/org/kasource/validation/xml/impl/spring.xml");
        Set<ConstraintViolation<Configuration>> constraintViolations =
            validator.validate(config);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void testXmlInvalid() {
        Configuration config = new Configuration("classpath:/org/kasource/validation/xml/impl/spring-invalid.xml");
        Set<ConstraintViolation<Configuration>> constraintViolations =
            validator.validate(config);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid XML or does not comply to the referenced XML Schema", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    private static class Configuration {
        @Xml
        private String springConfig;

        public Configuration(String springConfig) {
            super();
            this.springConfig = springConfig;
        }
        
        
    }
}
