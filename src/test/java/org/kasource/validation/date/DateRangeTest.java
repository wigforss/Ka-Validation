package org.kasource.validation.date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;


public class DateRangeTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
       ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
       validator = factory.getValidator();
    }
    
    @Test
    public void defaultRange() {
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Person object = new Person(today);
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(object);
        assertTrue(constraintViolations.isEmpty());
    }
    
    @Test
    public void unparseableDate() {
       
        Person object = new Person("uhuihwd43");
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("can not be parsed as date using format yyyy-MM-dd", 
                    constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void defaultRangeFail() {
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Person object = new Person("2014-07-27");
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("must be " + today, 
                    constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void rangeOffsetMinusFourHoursFail() {
        Person2 object = new Person2("2014-07-27");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, -4);
        Set<ConstraintViolation<Person2>> constraintViolations = validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("must be " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime()), 
                    constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void range5DaysEachOffset1Fail() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -4);
        String from = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        cal.add(Calendar.DAY_OF_YEAR, 10);
        String to = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        
        Person3 object = new Person3("2014-07-27");
        Set<ConstraintViolation<Person3>> constraintViolations = validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("must be between " + from + " and " + to, 
                    constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void pastTestFail() {
        HistoricPerson object = new HistoricPerson("2090-07-27");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);
        String to = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        Set<ConstraintViolation<HistoricPerson>> constraintViolations = validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("must be lesser or equal to " + to, 
                    constraintViolations.iterator().next().getMessage());
    }
    
    @Test
    public void futureTestFail() {
        FuturePerson object = new FuturePerson("2010-07-27");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        String from = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        Set<ConstraintViolation<FuturePerson>> constraintViolations = validator.validate(object);
        assertFalse(constraintViolations.isEmpty());
        assertEquals("must be greater or equal to " + from, 
                    constraintViolations.iterator().next().getMessage());
    }
    
    
    
    private static final class Person {
        @DateRange
        private String dateOfBirth;
        
        public Person(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }
    }
    
    private static final class Person2 {
        @DateRange(offset = -4, ignoreTimePart = false, timeUnit=TimeUnit.HOURS)
        private String dateOfBirth;
        
        public Person2(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }
    }
    
    private static final class Person3 {
        @DateRange(offset = 1, before = 5, after = 5)
        private String dateOfBirth;
        
        public Person3(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }
    }
    
    private static final class HistoricPerson {
        @DateRange(offset=-1, before = Integer.MAX_VALUE)
        private String dateOfBirth;
        
        public HistoricPerson(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }
    }
    
    private static final class FuturePerson {
        @DateRange(offset=1, after = Integer.MAX_VALUE)
        private String dateOfBirth;
        
        public FuturePerson(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }
    }
}
