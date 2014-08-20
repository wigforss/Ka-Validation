package org.kasource.commons.validation.checkdigit.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class IterableCheckdigitValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private IterableCheckdigitValidator validator;
    
    
    @Test
    public void listTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.ISBN)
                                   .build());
       List<String> list = new ArrayList<String>();
       list.add("91-32-33268-8");
       list.add("91-44-25231-5");
       assertTrue(validator.isValid(list, context));
    
    }
    
    @Test
    public void setTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.ISBN)
                                   .build());
       Set<String> set = new HashSet<String>();
       set.add("91-32-33268-8");
       set.add("91-44-25231-5");
       assertTrue(validator.isValid(set, context));
    
    }
    
    @Test
    public void listInvalidTest() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Checkdigit>(Checkdigit.class)
                                   .value(Algorithm.ISBN)
                                   .build());
       List<String> list = new ArrayList<String>();
       list.add("91-32-33268-8");
       list.add("91-32-33268-3");
       list.add("91-44-25231-5");
       assertFalse(validator.isValid(list, context));
    
    }
    
}
