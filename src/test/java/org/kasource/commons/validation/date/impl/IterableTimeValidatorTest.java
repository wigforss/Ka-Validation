package org.kasource.commons.validation.date.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.commons.validation.date.Time;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class IterableTimeValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private IterableTimeValidator validator;
    
    @Test
    public void listTest(){
        List<String> validTimes = Arrays.asList(new String[]{"14:59:00", "23:59:59"});
        List<String> invalidTimes = Arrays.asList(new String[]{"14:59:00", "23:59:59", "12:08 PM"});
       
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Time>(Time.class).build());
        assertTrue(validator.isValid(validTimes, context));
        assertFalse(validator.isValid(invalidTimes, context));     
    }
    
   
}
