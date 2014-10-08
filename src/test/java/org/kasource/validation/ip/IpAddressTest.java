package org.kasource.validation.ip;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;


public class IpAddressTest {
    private static Validator validator;
    
    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void validIp() {
       
        Computer computer = new Computer("127.0.0.1");
        
        Set<ConstraintViolation<Computer>> constraintViolations = validator.validate(computer);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void invalidIp() {
         
        Computer computer = new Computer("127.0.0.256");
        
        Set<ConstraintViolation<Computer>> constraintViolations = validator.validate(computer);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid IP address", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void invalidIpv4() {
         
        Computer2 computer = new Computer2("127.0.0.256");
        
        Set<ConstraintViolation<Computer2>> constraintViolations = validator.validate(computer);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("is not a valid IPv4 address", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    private static class Computer {
        @IpAddress
        String ip;

        public Computer(String ip) {
            this.ip = ip;
        }
        
        
    }
    
    private static class Computer2 {
        @IpAddress(ip4Only = true)
        String ip;
        
        public Computer2(String ip) {
            this.ip = ip;
        }
    }
}
