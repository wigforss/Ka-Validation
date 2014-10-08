package org.kasource.validation.ip.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.collection.builder.ListBuilder;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.ip.IpAddress;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class IterableIpAddressValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
        
    @TestedObject
    private IterableIpAddressValidator validator;
    
    @Test
    public void testIp6and4() {
       
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<IpAddress>(IpAddress.class).build());
       
        assertTrue(validator.isValid(new ListBuilder<String>().add("127.0.0.1", "213.100.33.42", "83.255.162.151").build(), context));
        assertTrue(validator.isValid(new ListBuilder<String>().add("127.0.0.1","2001:db8:0:1234:0:567:8:1", "::1", "::ffff:c000:0280", "::ffff:192.0.2.128").build(), context));
        assertFalse(validator.isValid(new ListBuilder<String>().add("127.0.0.1","1270.0.0.1").build(), context));
        assertFalse(validator.isValid(new ListBuilder<String>().add("127.0.0.1","1270.0.A.1").build(), context));
        
    }
    
    @Test
    public void testIp4Only() {
       
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<IpAddress>(IpAddress.class).attr("ip4Only", true).build());
       
        assertTrue(validator.isValid(new ListBuilder<String>().add("127.0.0.1", "213.100.33.42", "83.255.162.151").build(), context));
        assertFalse(validator.isValid(new ListBuilder<String>().add("127.0.0.1","2001:db8:0:1234:0:567:8:1", "::1").build(), context));
        assertFalse(validator.isValid(new ListBuilder<String>().add("127.0.0.1","1270.0.0.1").build(), context));
        assertFalse(validator.isValid(new ListBuilder<String>().add("127.0.0.1","1270.0.A.1").build(), context));
        
    }
}
