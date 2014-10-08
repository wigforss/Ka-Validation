package org.kasource.validation.locale.impl;

import javax.validation.ConstraintValidatorContext;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.locale.Country;
import org.kasource.validation.locale.Locale;
import org.kasource.validation.locale.impl.LocaleValidator;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class LocaleValidatorTest {
    
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private LocaleValidator validator;
    
    @Test
    public void testCaseSensitive() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Locale>(Locale.class).build());
       assertTrue(validator.isValid("en-US", context));
       assertTrue(validator.isValid("sv-SE", context));
       assertTrue(validator.isValid("en", context));
       assertFalse(validator.isValid("EN-US", context));
       assertFalse(validator.isValid("sv-se", context));
       assertFalse(validator.isValid("bu-LL", context));
    }
    
    @Test
    public void testCaseInsensitive() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Locale>(Locale.class).attr("caseSensetive", false).build());
       assertTrue(validator.isValid("en-US", context));
       assertTrue(validator.isValid("sv-SE", context));
       assertTrue(validator.isValid("EN-US", context));
       assertTrue(validator.isValid("sv-se", context));
       assertTrue(validator.isValid("en", context));   
       assertFalse(validator.isValid("bu-LL", context));
    }
}
