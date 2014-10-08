package org.kasource.validation.locale.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.collection.builder.ListBuilder;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.locale.Country;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class IterableCountryValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private IterableCountryValidator validator;
    
    @Test
    public void testCaseInsensitive() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Country>(Country.class).build());
       assertTrue(validator.isValid(new ListBuilder<String>().add("US", "SE", "GB", "us").build(), context));
       assertFalse(validator.isValid(new ListBuilder<String>().add("US", "LL").build(), context));
      
    }
    
    @Test
    public void testCaseSensitive() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Country>(Country.class).attr("caseSensetive", true).build());
       assertTrue(validator.isValid(new ListBuilder<String>().add("US", "SE", "GB").build(), context));
       assertFalse(validator.isValid(new ListBuilder<String>().add("US", "us").build(), context));
      
    }
}
