package org.kasource.validation.date.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.date.DateTimeFormat;
import org.kasource.validation.date.impl.DateTimeValidator;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class DateTimeValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private DateTimeValidator validator;
    
    @Test
    public void dateTimeTest(){
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<DateTimeFormat>(DateTimeFormat.class).build());
        assertTrue(validator.isValid("2014-07-27 14:59:00", context));
        assertFalse(validator.isValid("2014-07-27 14:59:00.123", context));
        assertFalse(validator.isValid("7/27/14 14:59:00", context));
        assertFalse(validator.isValid("2014-07-27 02:59:00 PM", context));
    }
    
    @Test
    public void changePattern() {
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<DateTimeFormat>(DateTimeFormat.class)
                    .value("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                    .build());
        assertTrue(validator.isValid("2001-07-04T12:08:56.235-0700", context));
        assertFalse(validator.isValid("2014-07-27 14:59:00", context));
        assertFalse(validator.isValid("2014-07-27 14:59:00.123", context));
        assertFalse(validator.isValid("7/27/14 14:59:00", context));
        assertFalse(validator.isValid("2014-07-27 02:59:00 PM", context));
        
    }
}
