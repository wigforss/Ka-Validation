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
public class CheckdigitValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private CheckdigitValidator validator;
    
    
    // Test algorithms
    
    @Test
    public void isbnTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.ISBN)
                                   .build());
       assertTrue(validator.isValid("91-32-33268-8", context));
    
    }
    
    @Test
    public void isbnInvalidTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.ISBN)
                                   .build());
       assertFalse(validator.isValid("91-32-33268-3", context));
    
    }
    
   
    
    @Test
    public void eanTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.EAN_13_UPC)
                                   .build());
       assertTrue(validator.isValid("9 789132 332685", context));
    
    }
    
    @Test
    public void eanInvalidTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.EAN_13_UPC)
                                   .build());
       assertFalse(validator.isValid("9 789132 332637", context));
    
    }
    
    
    @Test
    public void luhnTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.LUHN)
                                   .build());
       assertTrue(validator.isValid("502073-8455", context));
    
    }
    
    @Test
    public void luhnInvalidTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.LUHN)
                                   .build());
       assertFalse(validator.isValid("19502073-8455", context));
    
    }
    
   
    
    @Test
    public void cusipTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.CUSIP)
                                   .build());
       assertTrue(validator.isValid("345370100", context));
    
    }
    
    @Test
    public void cusipInvalidTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.CUSIP)
                                   .build());
       assertFalse(validator.isValid("345370700", context));
    
    }
    
    @Test
    public void verhoeffTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.VERHOEFF)
                                   .build());
       assertTrue(validator.isValid("123451", context));
    
    }
    
    @Test
    public void verhoeffInvalidTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.VERHOEFF)
                                   .build());
       assertFalse(validator.isValid("123453", context));
    
    }
    
    @Test
    public void abanTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.ABAN)
                                   .build());
       assertTrue(validator.isValid("211274450", context));
    
    }
    
    @Test
    public void abanInvalidTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.ABAN)
                                   .build());
       assertFalse(validator.isValid("211274470", context));
    
    }
    
    @Test
    public void ibanTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.IBAN)
                                   .build());
       assertTrue(validator.isValid("CY17002001280000001200527600", context));
    
    }
    
    @Test
    public void ibanInvalidTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.IBAN)
                                   .build());
       assertFalse(validator.isValid("CY17002001280000001300527600", context));
    
    }
    
    @Test
    public void isinTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.ISIN)
                                   .build());
       assertTrue(validator.isValid("SE0006028023", context));
    
    }
    
    @Test
    public void isinInvalidTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.ISIN)
                                   .build());
       assertFalse(validator.isValid("SE0006028027", context));
    
    }
    
    @Test
    public void sedolTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.SEDOL)
                                   .build());
       assertTrue(validator.isValid("B0WNLY7", context));
    
    }
    
    @Test
    public void sedolInvalidTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.SEDOL)
                                   .build());
       assertFalse(validator.isValid("B0WNLY3", context));
    
    }
    
    
}
