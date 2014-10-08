package org.kasource.validation.isbn.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.isbn.Isbn;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class ArrayIsbnValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
        
    @TestedObject
    private ArrayIsbnValidator validator;
    
    @Test
    public void testIsbn() {
       
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Isbn>(Isbn.class).build());
       
        assertTrue(validator.isValid(new String[]{"9781591025948", "159102594X"}, context));
        assertFalse(validator.isValid(new String[]{"9781591025948", "159102594X", "159102594G"}, context));
        
    }
}
