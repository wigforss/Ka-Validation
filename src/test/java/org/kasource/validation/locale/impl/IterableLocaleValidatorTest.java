package org.kasource.validation.locale.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
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
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void test() {
       EasyMockUnitils.replay();
       assertTrue( validator.isValid((Iterable) Arrays.asList(new String[]{"en-US"}), context));
       assertTrue(validator.isValid((Iterable)Arrays.asList(new String[]{"en-US", "sv-SE", "en"}), context));
       
       assertFalse(validator.isValid((Iterable)Arrays.asList(new String[]{"en-US", "sv-SE", "en", "bu-LL"}), context));
    }
}
