package org.kasource.validation.url.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.collection.builder.ListBuilder;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.url.Url;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class IterableUrlValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private IterableUrlValidator validator;
    
    @Test
    public void testAnyProtocol() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Url>(Url.class).build());
       
       assertTrue(validator.isValid(new ListBuilder<String>().add("http://kth.se#anchor", "file://users/rikardwi").build(), context));
       
       assertFalse(validator.isValid(new ListBuilder<String>().add("http://kth.se#anchor","mailto:someone@example.com").build(), context));
    }
    
    @Test
    public void testHttpProtocol() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Url>(Url.class).value(new String[]{"http", "https"}).build());
         
       assertTrue(validator.isValid(new ListBuilder<String>().add("http://kth.se//resource#anchor", "https://kth.se", "http://localhost/").build(), context));
      
       assertFalse(validator.isValid(new ListBuilder<String>().add("http://kth.se//resource#anchor", "file://users/rikardwi").build(), context));
     
    }
    
    @Test
    public void testHttpNoDoubleSlahses() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Url>(Url.class).value(new String[]{"http", "https"}).attr("allowTwoSlahes", false).build());
       assertTrue(validator.isValid(new ListBuilder<String>().add("http://localhost/", "http://kth.se/resource#anchor","https://kth.se").build(), context));
            
       assertFalse(validator.isValid(new ListBuilder<String>().add("http://localhost/", "http://kth.se//resource").build(), context));

    }
    
    @Test
    public void testHttpNoLocal() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Url>(Url.class).value(new String[]{"http", "https"}).attr("allowLocalUrls", false).build());
         
       assertTrue(validator.isValid(new ListBuilder<String>().add("http://kth.se/resource#anchor", "https://kth.se", "http://kth.se//resource").build(), context));
       
       assertFalse(validator.isValid(new ListBuilder<String>().add("http://kth.se/resource#anchor","http://localhost/").build(), context));
 
    }
    
    @Test
    public void testHttpNoFragment() {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Url>(Url.class).value(new String[]{"http", "https"}).attr("allowFragments", false).build());
        
       assertTrue(validator.isValid(new ListBuilder<String>().add("http://localhost/", "https://kth.se","http://kth.se//resource").build(), context));
         
       assertFalse(validator.isValid(new ListBuilder<String>().add("http://localhost/", "http://kth.se/resource#anchor").build(), context));
   
    }
}
