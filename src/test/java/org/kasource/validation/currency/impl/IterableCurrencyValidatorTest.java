package org.kasource.validation.currency.impl;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.collection.builder.ListBuilder;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.currency.Currency;
import org.kasource.validation.currency.CurrencyCode;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class IterableCurrencyValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @Mock
    private ConstraintViolationBuilder violationBuilder;
    
    @TestedObject
    private IterableCurrencyValidator validator;
    
    @Test
    public void testUsd() {
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Currency>(Currency.class).build());
        assertTrue(validator.isValid(new ListBuilder<String>().add("USD").build(), context));
    }
    
    @Test
    public void testUnknown() {
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Currency>(Currency.class).build());
        assertFalse(validator.isValid(new ListBuilder<String>().add("USD","123").build(), context));
    }
    
    @Test
    public void testScandinavioan() {
       
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.currency.Currency.alt.many}")).andReturn(violationBuilder);
        expect(violationBuilder.addConstraintViolation()).andReturn(context);
        EasyMockUnitils.replay();
       
        validator.initialize(new AnnotationBuilder<Currency>(Currency.class).value(new CurrencyCode[]{CurrencyCode.SEK, CurrencyCode.NOK, CurrencyCode.DKK}).build());
        assertFalse(validator.isValid(new ListBuilder<String>().add("SEK", "NOK", "DKK", "USD").build(), context));
        assertTrue(validator.isValid(new ListBuilder<String>().add("SEK", "NOK", "DKK").build(), context));
      
    }
}
