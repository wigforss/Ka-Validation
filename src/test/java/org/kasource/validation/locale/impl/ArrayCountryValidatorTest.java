package org.kasource.validation.locale.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.locale.Country;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class ArrayCountryValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private ArrayCountryValidator validator;
    
    @Test
    public void testCaseInsensitive() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Country>(Country.class).build());
       assertTrue(validator.isValid(new String[]{"US", "SE", "GB", "us"}, context));
       assertFalse(validator.isValid(new String[]{"US", "LL"}, context));
      
    }
    
    @Test
    public void testCaseSensitive() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Country>(Country.class).attr("caseSensetive", true).build());
       assertTrue(validator.isValid(new String[]{"US", "SE", "GB"}, context));
       assertFalse(validator.isValid(new String[]{"US", "us"}, context));
      
    }
}
