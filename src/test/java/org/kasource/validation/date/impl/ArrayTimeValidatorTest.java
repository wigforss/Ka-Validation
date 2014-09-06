package org.kasource.validation.date.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.date.TimeFormat;
import org.kasource.validation.date.impl.ArrayTimeValidator;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class ArrayTimeValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private ArrayTimeValidator validator;
    
    @Test
    public void arrayTest(){
        String[] validTimes = {"14:59:00", "23:59:59"};
        String[] invalidTimes = {"14:59:00", "23:59:59", "12:08 PM"};
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<TimeFormat>(TimeFormat.class).build());
        assertTrue(validator.isValid(validTimes, context));
        assertFalse(validator.isValid(invalidTimes, context));     
    }
    
   
}
