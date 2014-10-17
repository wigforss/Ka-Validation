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
import org.kasource.validation.creditcard.impl.ArrayCreditCardValidator;
import org.kasource.validation.reflection.impl.JavaClassValidator;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class ArrayCreditCardValidatorTest {
    private static final String VISA = "4012888888881881";
    private static final String MASTER_CARD = "5105105105105100";
    private static final String AMEX = "378282246310005";
    private static final String DINERS = "38520000023237";
   
    
    @Mock
    private ConstraintValidatorContext context;
    
    @Mock
    private ConstraintViolationBuilder builder;
    
    @TestedObject
    private ArrayCreditCardValidator validator;
    
    
    @Test
    public void arrayTest() {
        
        String[] cards = {VISA, MASTER_CARD, AMEX};
       
        
        String[] cardsWithDiners = {VISA, MASTER_CARD, DINERS, AMEX};
        
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.creditcard.CreditCard.alt.3}"))
                    .andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<CreditCard>(CreditCard.class)
                    .value(new CardType[]{CardType.VISA, CardType.MASTERCARD, CardType.AMEX})
                    .build());
        assertTrue(validator.isValid(cards, context));
        assertFalse(validator.isValid(cardsWithDiners, context));
       
    }
    
}
