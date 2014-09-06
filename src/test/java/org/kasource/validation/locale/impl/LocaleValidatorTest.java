package org.kasource.validation.locale.impl;

import javax.validation.ConstraintValidatorContext;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
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
    public void test() {
       EasyMockUnitils.replay();
       assertTrue(validator.isValid("en-US", context));
       assertTrue(validator.isValid("sv-SE", context));
       assertTrue(validator.isValid("en", context));
       assertFalse(validator.isValid("bu-LL", context));
    }
}
