package org.kasource.validation.locale.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.locale.Language;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class ArrayLanguageValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private ArrayLanguageValidator validator;
    
    @Test
    public void testCaseInsensitive() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Language>(Language.class).build());
       
       assertTrue(validator.isValid(new String[]{"en", "sv", "de", "EN"}, context));
      
       assertFalse(validator.isValid(new String[]{"en", "bu"}, context));
       
    }
    
    @Test
    public void testCaseSensitive() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Language>(Language.class).attr("caseSensetive", true).build());
       
       assertTrue(validator.isValid(new String[]{"en", "sv", "de"}, context));
       
       assertFalse(validator.isValid(new String[]{"en", "EN"}, context));
       
    }
}
