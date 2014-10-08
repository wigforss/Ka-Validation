package org.kasource.validation.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;


public class FileTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void validExecutableFile() {
        String javaExecutable = System.getProperty("java.home") + java.io.File.separator + "bin" + java.io.File.separator + "java";
        
        Script script = new Script(javaExecutable);
        
        Set<ConstraintViolation<Script>> constraintViolations = validator.validate(script);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void invalidExecutableFile() {
         
        Script script = new Script(UUID.randomUUID().toString());
        
        Set<ConstraintViolation<Script>> constraintViolations = validator.validate(script);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid executable file", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    private static class Script {
        @File(FileOperation.EXECUTABLE_FILE)
        private String scriptFile;
        
        public Script(String scriptFile) {
            this.scriptFile = scriptFile;
        }
    }
}
