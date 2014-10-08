package org.kasource.validation.date.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.collection.builder.ListBuilder;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.date.DateRange;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class IterableDateRangeValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private IterableDateRangeValidator validator;
    
    @Test
    public void dateRangeDefaultTest() {
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<DateRange>(DateRange.class).build());
        assertTrue(validator.isValid(new ListBuilder<String>().add(today).build(), context));
        assertFalse(validator.isValid(new ListBuilder<String>().add(today, "2014-07-27").build(), context));     
    }
    
    @Test
    public void dateRangePastTest() {
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<DateRange>(DateRange.class).attr("offset", -1)
                                                                              .attr("before", Integer.MAX_VALUE)
                                                                              .build());
        assertFalse(validator.isValid(new ListBuilder<String>().add(today, "2014-07-27").build(), context));
        assertTrue(validator.isValid(new ListBuilder<String>().add("2014-07-27", "2014-07-27").build(), context));   
    }
    
    @Test
    public void dateRangeFutureTest() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        String tomorrow = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<DateRange>(DateRange.class).attr("offset", 1)
                                                                              .attr("after", Integer.MAX_VALUE)
                                                                              .build());
        assertFalse(validator.isValid(new ListBuilder<String>().add(tomorrow, today).build(), context));
        assertTrue(validator.isValid(new ListBuilder<String>().add(tomorrow).build(), context));   
    }
    
    @Test
    public void dateRangeTest() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 7);
        String weekAfter = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 8);
        String weekAndaDayAfter = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<DateRange>(DateRange.class).attr("before", 7)
                                                                              .attr("after", 7)
                                                                              .build());
        assertTrue(validator.isValid(new ListBuilder<String>().add(today, weekAfter).build(), context));
     
        assertFalse(validator.isValid(new ListBuilder<String>().add(today, weekAfter, weekAndaDayAfter).build(), context));  
    }
}
