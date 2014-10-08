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
public class IsbnValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
        
    @TestedObject
    private IsbnValidator validator;
    
    @Test
    public void testIsbn() {
       
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Isbn>(Isbn.class).build());
       
        assertTrue(validator.isValid("9781591025948", context));
        assertTrue(validator.isValid("159102594X", context));
        assertFalse(validator.isValid("159102594G", context));
        
    }
}
