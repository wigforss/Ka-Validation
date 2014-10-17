package org.kasource.validation.creditcard.impl;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.creditcard.CardType;
import org.kasource.validation.creditcard.CreditCard;
import org.kasource.validation.creditcard.impl.CreditCardValidator;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class CreditCardValidatorTest {
    private static final String VISA = "4012888888881881";
    private static final String MASTER_CARD = "5105105105105100";
    private static final String AMEX = "378282246310005";
    private static final String DINERS = "38520000023237";
    private static final String DISCOVER = "6011000990139424";
    
    @Mock
    private ConstraintValidatorContext context;
    
    @Mock
    private ConstraintViolationBuilder builder;
    
    @TestedObject
    private CreditCardValidator validator;
    
    @Test
    public void testVisa() {
        int times = 5;
        context.disableDefaultConstraintViolation();
        expectLastCall().times(times);
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.creditcard.CreditCard.alt.1}"))
                    .andReturn(builder).times(times);
        expect(builder.addConstraintViolation()).andReturn(context).times(times);
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<CreditCard>(CreditCard.class)
                                .value(new CardType[]{CardType.VISA})
                                .build());
        assertTrue(validator.isValid(VISA, context));
        assertFalse(validator.isValid(MASTER_CARD, context));
        assertFalse(validator.isValid(AMEX, context));
        assertFalse(validator.isValid(DINERS, context));
        assertFalse(validator.isValid(DISCOVER, context));
        assertFalse(validator.isValid("21231214325", context));
    }
    
   
    
    @Test
    public void testMasterCard() {
        
        int times = 5;
        context.disableDefaultConstraintViolation();
        expectLastCall().times(times);
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.creditcard.CreditCard.alt.1}"))
                    .andReturn(builder).times(times);
        expect(builder.addConstraintViolation()).andReturn(context).times(times);
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<CreditCard>(CreditCard.class)
                                .value(new CardType[]{CardType.MASTERCARD})
                                .build());
        assertTrue(validator.isValid(MASTER_CARD, context));
        assertFalse(validator.isValid(VISA, context));
        assertFalse(validator.isValid(AMEX, context));
        assertFalse(validator.isValid(DINERS, context));
        assertFalse(validator.isValid(DISCOVER, context));
        assertFalse(validator.isValid("8942310978342179", context));
    }
    
   
    
    @Test
    public void testAmex() {
        int times = 5;
        context.disableDefaultConstraintViolation();
        expectLastCall().times(times);
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.creditcard.CreditCard.alt.1}"))
                    .andReturn(builder).times(times);
        expect(builder.addConstraintViolation()).andReturn(context).times(times);
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<CreditCard>(CreditCard.class)
                                .value(new CardType[]{CardType.AMEX})
                                .build());
        assertTrue(validator.isValid(AMEX, context));
        assertFalse(validator.isValid(VISA, context));
        assertFalse(validator.isValid(MASTER_CARD, context));
        assertFalse(validator.isValid(DINERS, context));
        assertFalse(validator.isValid(DISCOVER, context));
        assertFalse(validator.isValid("132654123978", context));
    }
    
    
    
    @Test
    public void testDiners() {
        int times = 5;
        context.disableDefaultConstraintViolation();
        expectLastCall().times(times);
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.creditcard.CreditCard.alt.1}"))
                    .andReturn(builder).times(times);
        expect(builder.addConstraintViolation()).andReturn(context).times(times);
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<CreditCard>(CreditCard.class)
                                .value(new CardType[]{CardType.DINERS})
                                .build());
        assertTrue(validator.isValid(DINERS, context));
        assertFalse(validator.isValid(VISA, context));
        assertFalse(validator.isValid(MASTER_CARD, context));
        assertFalse(validator.isValid(AMEX, context));
        assertFalse(validator.isValid(DISCOVER, context));
        assertFalse(validator.isValid("980132569986", context));
    }
    
    
    
    @Test
    public void testDiscover() {
        int times = 5;
        context.disableDefaultConstraintViolation();
        expectLastCall().times(times);
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.creditcard.CreditCard.alt.1}"))
                    .andReturn(builder).times(times);
        expect(builder.addConstraintViolation()).andReturn(context).times(times);
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<CreditCard>(CreditCard.class)
                                .value(new CardType[]{CardType.DISCOVER})
                                .build());
        assertTrue(validator.isValid(DISCOVER, context));
        assertFalse(validator.isValid(VISA, context));
        assertFalse(validator.isValid(MASTER_CARD, context));
        assertFalse(validator.isValid(AMEX, context));
        assertFalse(validator.isValid(DINERS, context));
        assertFalse(validator.isValid("983217765321", context));
    }
    
   
    
    @Test
    public void testVisaMasterCardAmx() {
        int times = 2;
        context.disableDefaultConstraintViolation();
        expectLastCall().times(times);
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.creditcard.CreditCard.alt.3}"))
                    .andReturn(builder).times(times);
        expect(builder.addConstraintViolation()).andReturn(context).times(times);
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<CreditCard>(CreditCard.class)
                                .value(new CardType[]{CardType.VISA, CardType.MASTERCARD, CardType.AMEX})
                                .build());
        assertTrue(validator.isValid(VISA, context));
        assertTrue(validator.isValid(MASTER_CARD, context));
        assertTrue(validator.isValid(AMEX, context));
        assertFalse(validator.isValid(DINERS, context));
        assertFalse(validator.isValid(DISCOVER, context));
    }
    
    @Test
    public void testAll() {
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<CreditCard>(CreditCard.class).build());
        
        assertTrue(validator.isValid(VISA, context));
        assertTrue(validator.isValid(MASTER_CARD, context));
        assertTrue(validator.isValid(AMEX, context));
        assertTrue(validator.isValid(DINERS, context));
        assertTrue(validator.isValid(DISCOVER, context));
    }
    
}
