package org.kasource.commons.validation.checkdigit.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.math.BigInteger;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.commons.validation.checkdigit.Algorithm;
import org.kasource.commons.validation.checkdigit.Checkdigit;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class NumberCheckDigitValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private NumberCheckdigitValidator validator;
    
    @Test
    public void shortTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.LUHN)
                                   .build());
       assertTrue(validator.isValid((short) 1230, context));
    
    }
    
    @Test
    public void intTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.LUHN)
                                   .build());
       assertTrue(validator.isValid(1230, context));
    
    }
    
    /**
     * Fails to validate a correct code, since leading zeros is not preserved in
     * numbers.
     **/
    @Test
    public void intTestLeadingZeroTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.ABAN)
                                   .build());
       assertFalse(validator.isValid(021302567, context));
    
    }
    
    @Test
    public void longTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.LUHN)
                                   .build());
       assertTrue(validator.isValid(5020738455L, context));
    
    }
    
    @Test
    public void bigIntegerTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.LUHN)
                                   .build());
       assertTrue(validator.isValid(new BigInteger("5020738455"), context));
    
    }
    
    
    
   
}
