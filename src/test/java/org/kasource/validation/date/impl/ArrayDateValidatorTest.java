package org.kasource.validation.date.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.date.DateFormat;
import org.kasource.validation.date.impl.ArrayDateValidator;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class ArrayDateValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private ArrayDateValidator validator;
    
    @Test
    public void dateTimeTest(){
        String[] valid = {"2014-07-27", "2013-05-02"};
        String[] invalid = {"2014-07-27", "2013-05-02", "14/07/27"};
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<DateFormat>(DateFormat.class).build());
        assertTrue(validator.isValid(valid, context));
        assertFalse(validator.isValid(invalid, context));
    }
}
