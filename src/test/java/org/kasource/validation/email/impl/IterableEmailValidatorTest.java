package org.kasource.validation.email.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.collection.builder.ListBuilder;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.email.Email;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class IterableEmailValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
        
    @TestedObject
    private IterableEmailValidator validator;
    
    @Test
    public void testValidEmail() {
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Email>(Email.class).build());
        assertTrue(validator.isValid(new ListBuilder<String>().add("rikard.wigforss@example.com", "rikard.wigforss@somedomain.com").build(), context));
    }
    
    @Test
    public void testValidLocalEmail() {
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Email>(Email.class).attr("allowLocalAddresses", true).build());
        assertTrue(validator.isValid(new ListBuilder<String>().add("rikard.wigforss@example.com","rikard.wigforss@local").build(), context));
    }
    
    @Test
    public void testInvalidEmail() {
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<Email>(Email.class).build());
        
        assertFalse(validator.isValid(new ListBuilder<String>().add("rikard.wigforss@local", "rikard.wigforss@example.com").build(), context));
        assertFalse(validator.isValid(new ListBuilder<String>().add("rikard.wigforss@example.com", "Abc.example.com").build(), context));
    }
}
