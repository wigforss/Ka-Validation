package org.kasource.validation.enumeration.impl;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.concurrent.TimeUnit;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;

import org.kasource.validation.enumeration.Enumeration;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;


@RunWith(UnitilsJUnit4TestClassRunner.class)
public class EnumerationValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @Mock
    private ConstraintViolationBuilder violationBuilder;
        
    @TestedObject
    private EnumerationValidator validator;
    
    @Test
    public void testValidEnumerationValue() {
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Enumeration>(Enumeration.class).value(TimeUnit.class).build());
        assertTrue(validator.isValid("SECONDS", context));
        assertTrue(validator.isValid("seconds", context));
        assertTrue(validator.isValid("Seconds", context));
    }
    
    
    @Test
    public void testCaseSensitiveEnumerationValue() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.enumeration.Enumeration} TimeUnit {validation.message.valid.value} [NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS]")).andReturn(violationBuilder);
        expect(violationBuilder.addConstraintViolation()).andReturn(context);
        EasyMockUnitils.replay();
       
        validator.initialize(new AnnotationBuilder<Enumeration>(Enumeration.class).value(TimeUnit.class).attr("caseSensetive", true).build());
        assertFalse(validator.isValid("seconds", context));
    }
    
    @Test
    public void testInvalidEnumerationValue() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.enumeration.Enumeration} TimeUnit {validation.message.valid.value} [NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS]")).andReturn(violationBuilder);
        expect(violationBuilder.addConstraintViolation()).andReturn(context);
        EasyMockUnitils.replay();
       
        validator.initialize(new AnnotationBuilder<Enumeration>(Enumeration.class).value(TimeUnit.class).attr("caseSensetive", true).build());
        assertFalse(validator.isValid("SE", context));
    }
}

