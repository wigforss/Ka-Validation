package org.kasource.commons.validation.creditcard.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.commons.validation.creditcard.CardType;
import org.kasource.commons.validation.creditcard.CreditCard;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class IterableCreditCardValidatorTest {
    private static final String VISA = "4012888888881881";
    private static final String MASTER_CARD = "5105105105105100";
    private static final String AMEX = "378282246310005";
    private static final String DINERS = "38520000023237";
   
    
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private IterableCreditCardValidator validator;
    
    @Test
    public void listTest() {
        
        List<String> cards = new ArrayList<String>();
        cards.add(VISA);
        cards.add(MASTER_CARD);
        cards.add(AMEX);
        
        List<String> cardsWithDiners = new ArrayList<String>();
        cardsWithDiners.add(VISA);
        cardsWithDiners.add(MASTER_CARD);
        cardsWithDiners.add(DINERS);
        cardsWithDiners.add(AMEX);
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<CreditCard>(CreditCard.class)
                    .value(new CardType[]{CardType.VISA, CardType.MASTERCARD, CardType.AMEX})
                    .build());
        assertTrue(validator.isValid(cards, context));
        assertFalse(validator.isValid(cardsWithDiners, context));
       
    }
    
    @Test
    public void setTest() {
        
        Set<String> cards = new HashSet<String>();
        cards.add(VISA);
        cards.add(MASTER_CARD);
        cards.add(AMEX);
        
        Set<String> cardsWithDiners = new HashSet<String>();
        cardsWithDiners.add(VISA);
        cardsWithDiners.add(MASTER_CARD);
        cardsWithDiners.add(DINERS);
        cardsWithDiners.add(AMEX);
        
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<CreditCard>(CreditCard.class)
                    .value(new CardType[]{CardType.VISA, CardType.MASTERCARD, CardType.AMEX})
                    .build());
        assertTrue(validator.isValid(cards, context));
        assertFalse(validator.isValid(cardsWithDiners, context));
       
    }
    
   
    
}
