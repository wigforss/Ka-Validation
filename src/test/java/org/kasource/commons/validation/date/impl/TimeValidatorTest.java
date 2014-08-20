package org.kasource.commons.validation.date.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
public class TimeValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private TimeValidator validator;
    
    @Test
    public void timeTest(){
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Time>(Time.class).build());
        assertTrue(validator.isValid("14:59:00", context));
        assertFalse(validator.isValid("14:59:00.123", context));
        assertFalse(validator.isValid("12:08 PM", context));
        assertFalse(validator.isValid("02:59:00 PM", context));
        assertFalse(validator.isValid("January 1, 2014", context));
        assertFalse(validator.isValid("2121323231", context));
    }
    
    @Test
    public void timeChangePatternTest(){
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Time>(Time.class)
                                .value("h:mm a")
                                .build());
        assertTrue(validator.isValid("12:08 PM", context));
        assertTrue(validator.isValid("12:08 pm", context));
        assertFalse(validator.isValid("14:59:00", context));
        assertFalse(validator.isValid("14:59:00.123", context));      
        assertFalse(validator.isValid("02:59:00 PM", context));
        assertFalse(validator.isValid("January 1, 2014", context));
        assertFalse(validator.isValid("2121323231", context));
    }
    
    
}
