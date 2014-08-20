package org.kasource.commons.validation.date.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.commons.validation.date.DateTime;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class IterableDateTimeValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private IterableDateTimeValidator validator;
    
    @Test
    public void listTest(){
        List<String> valid = Arrays.asList(new String[]{"2014-07-27 14:59:00", "2013-12-24 23:59:59"});
        List<String> inValid = Arrays.asList(new String[]{"2014-07-27 14:59:00", "7/27/14 2:59:00 PM", "2013-12-24 23:59:59"});
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<DateTime>(DateTime.class).build());
        assertTrue(validator.isValid(valid, context));
        assertFalse(validator.isValid(inValid, context));
    }
    
}
