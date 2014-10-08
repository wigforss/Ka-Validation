package org.kasource.validation.locale.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.collection.builder.ListBuilder;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.locale.Locale;
import org.kasource.validation.locale.impl.IterableLocaleValidator;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class IterableLocaleValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private IterableLocaleValidator validator;
    

    
    @Test
    public void testCaseSensitive() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Locale>(Locale.class).build());
       assertTrue(validator.isValid(new ListBuilder<String>().add("en-US", "sv-SE").build(), context));
       assertFalse(validator.isValid(new ListBuilder<String>().add("en-US", "sv-SE", "EN-US").build(), context));
      
    }
    
    @Test
    public void testCaseInsensitive() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Locale>(Locale.class).attr("caseSensetive", false).build());
     
       assertTrue( validator.isValid(new ListBuilder<String>().add("en-US", "sv-SE", "EN-US", "sv-se").build(), context));
       assertFalse( validator.isValid(new ListBuilder<String>().add("en-US", "sv-SE","bu-LL").build(), context));
       
      
    }
}
