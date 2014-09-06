package org.kasource.validation.checkdigit.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.checkdigit.Algorithm;
import org.kasource.validation.checkdigit.Checkdigit;
import org.kasource.validation.checkdigit.impl.CheckdigitValidator;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class CheckDigitValidatorAnnotationTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private CheckdigitValidator validator;
    
  
    @Test
    public void prefixTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.LUHN)
                                   .attr("prefixLength", 2)                               
                                   .build());
       assertFalse(validator.isValid("502073-8455", context));
       assertTrue(validator.isValid("19502073-8455", context));
    
    }
    
    @Test
    public void suffixTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.LUHN)
                                   .attr("suffixLength", 1)                               
                                   .build());
       assertFalse(validator.isValid("502073-8455", context));
       assertTrue(validator.isValid("502073-8455X", context));
    
    }
    
    
    @Test
    public void prefixSuffixTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.LUHN)
                                   .attr("prefixLength", 2)
                                   .attr("suffixLength", 1)
                                   .build());
       assertFalse(validator.isValid("502073-8455", context));
       assertTrue(validator.isValid("19502073-8455X", context));
    
    }
    
    @Test
    public void noSeparatorsTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                               .value(Algorithm.ISBN)
                               .attr("allowSeparators", false)
                               .build());
       assertTrue(validator.isValid("9132332688", context));
       assertFalse(validator.isValid("91-32-33268-8", context));
    
    }
    
    @Test
    public void changeSeparatorsTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                               .value(Algorithm.ISBN)
                               .attr("separators", new String[]{"|", "*"})
                               .build());
       assertTrue(validator.isValid("9132332688", context));
       assertTrue(validator.isValid("9132|33268*8", context));
    
    }
}
