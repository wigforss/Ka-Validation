package org.kasource.validation.date.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.date.DateFormat;
import org.kasource.validation.date.impl.DateValidator;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class DateValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private DateValidator validator;
    
    @Test
    public void dateTimeTest(){
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<DateFormat>(DateFormat.class).build());
        assertTrue(validator.isValid("2014-07-27", context));
        assertTrue(validator.isValid("14-07-27", context));
        assertFalse(validator.isValid("14/07/27", context));
        assertFalse(validator.isValid("7/27/14", context));
        assertFalse(validator.isValid("2014-07-27 12:00:00", context));
        assertFalse(validator.isValid("January 1, 2014", context));
        assertFalse(validator.isValid("2121323231", context));
    }
}
