package org.kasource.validation.locale.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.locale.Locale;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class ArrayLocaleValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private ArrayLocaleValidator validator;
    
   
    @Test
    public void test() {
       EasyMockUnitils.replay();
       assertTrue( validator.isValid(new String[]{"en-US"}, context));
       assertTrue(validator.isValid(new String[]{"en-US", "sv-SE", "en"}, context));
       
       assertFalse(validator.isValid(new String[]{"en-US", "sv-SE", "en", "bu-LL"}, context));
    }
    
    @Test
    public void testCaseSensitive() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Locale>(Locale.class).build());
       assertTrue( validator.isValid(new String[]{"en-US", "sv-SE"}, context));
       assertFalse( validator.isValid(new String[]{"en-US", "sv-SE", "EN-US"}, context));
      
    }
    
    @Test
    public void testCaseInsensitive() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Locale>(Locale.class).attr("caseSensetive", false).build());
     
       assertTrue( validator.isValid(new String[]{"en-US", "sv-SE", "EN-US", "sv-se"}, context));
       assertFalse( validator.isValid(new String[]{"en-US", "sv-SE","bu-LL"}, context));
       
      
    }
}
