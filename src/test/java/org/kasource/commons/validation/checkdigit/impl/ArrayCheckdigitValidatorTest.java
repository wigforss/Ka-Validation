package org.kasource.commons.validation.checkdigit.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
public class ArrayCheckdigitValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private ArrayCheckdigitValidator validator;
    
    
    @Test
    public void arrayStringTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.ISBN)
                                   .build());
       String[] array = new String[] {"91-32-33268-8", "91-44-25231-5"};
      
       assertTrue(validator.isValid(array, context));
    
    }
    
    @Test
    public void arrayLongTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.ISBN)
                                   .build());
       Long[] array = new Long[] {9132332688L, 9144252315L};
      
       assertTrue(validator.isValid(array, context));
    
    }
    
    
    
    @Test
    public void arrayInvalidTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.ISBN)
                                   .build());
       String[] array = new String[] {"91-32-33268-8", "91-32-33268-3", "91-44-25231-5"};
     
       assertFalse(validator.isValid(array));
    
    }
    
}
