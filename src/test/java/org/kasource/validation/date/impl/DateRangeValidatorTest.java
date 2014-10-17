package org.kasource.validation.date.impl;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.date.DateRange;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class DateRangeValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @Mock
    private ConstraintViolationBuilder builder;
    
    @TestedObject
    private DateRangeValidator validator;
    
    @Test
    public void dateRangeDefaultTest() {
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.date.DateRange.alt.one} " + today))
                    .andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<DateRange>(DateRange.class).build());
        assertTrue(validator.isValid(today, context));
        assertFalse(validator.isValid("2014-07-27", context));     
    }
    
    @Test
    public void dateRangePastTest() {
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);
        String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.date.DateRange.alt.lesser} " + yesterday))
                    .andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<DateRange>(DateRange.class).attr("offset", -1)
                                                                              .attr("before", Integer.MAX_VALUE)
                                                                              .build());
        assertFalse(validator.isValid(today, context));
        assertTrue(validator.isValid("2014-07-27", context));   
    }
    
    @Test
    public void dateRangeFutureTest() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        String tomorrow = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.date.DateRange.alt.greater} " + tomorrow))
                    .andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<DateRange>(DateRange.class).attr("offset", 1)
                                                                              .attr("after", Integer.MAX_VALUE)
                                                                              .build());
        assertFalse(validator.isValid(today, context));
        assertTrue(validator.isValid(tomorrow, context));   
    }
    
    @Test
    public void dateRangeTest() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -7);
        String weekBefore = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 7);
        String weekAfter = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 8);
        String weekAndaDayAfter = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.date.DateRange.alt.range} " + weekBefore + " {validation.message.and} " + weekAfter))
                    .andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<DateRange>(DateRange.class).attr("before", 7)
                                                                              .attr("after", 7)
                                                                              .build());
        assertTrue(validator.isValid(today, context));
        assertTrue(validator.isValid(weekAfter, context));  
        assertFalse(validator.isValid(weekAndaDayAfter, context));  
    }
}
