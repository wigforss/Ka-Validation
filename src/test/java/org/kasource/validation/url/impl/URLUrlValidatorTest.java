package org.kasource.validation.url.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.url.Url;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class URLUrlValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private URLUrlValidator validator;
    
    @Test
    public void testAnyProtocol() throws MalformedURLException {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Url>(Url.class).build());
       
       assertTrue(validator.isValid(new URL("http://kth.se#anchor"), context));
       assertTrue(validator.isValid(new URL("file://users/rikardwi"), context));
       assertFalse(validator.isValid(new URL("mailto:someone@example.com"), context));
    }
    
    @Test
    public void testHttpProtocol() throws MalformedURLException {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Url>(Url.class).value(new String[]{"http", "https"}).build());
       
       assertTrue(validator.isValid(new URL("http://kth.se//resource#anchor"), context));
       assertTrue(validator.isValid(new URL("https://kth.se"), context));
       assertTrue(validator.isValid(new URL("http://localhost/"), context));
       assertFalse(validator.isValid(new URL("file://users/rikardwi"), context));
       assertFalse(validator.isValid(new URL("mailto:someone@example.com"), context));
    }
    
    @Test
    public void testHttpNoDoubleSlahses() throws MalformedURLException {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Url>(Url.class).value(new String[]{"http", "https"}).attr("allowTwoSlahes", false).build());
       assertTrue(validator.isValid(new URL("http://localhost/"), context));
       assertTrue(validator.isValid(new URL("http://kth.se/resource#anchor"), context));
       assertTrue(validator.isValid(new URL("https://kth.se"), context));
       assertFalse(validator.isValid(new URL("http://kth.se//resource"), context));
       assertFalse(validator.isValid(new URL("file://users/rikardwi"), context));
       assertFalse(validator.isValid(new URL("mailto:someone@example.com"), context));
    }
    
    @Test
    public void testHttpNoLocal() throws MalformedURLException {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Url>(Url.class).value(new String[]{"http", "https"}).attr("allowLocalUrls", false).build());
      
       assertTrue(validator.isValid(new URL("http://kth.se/resource#anchor"), context));
       assertTrue(validator.isValid(new URL("https://kth.se"), context));
       assertTrue(validator.isValid(new URL("http://kth.se//resource"), context));
       assertFalse(validator.isValid(new URL("http://localhost/"), context));
       assertFalse(validator.isValid(new URL("file://users/rikardwi"), context));
       assertFalse(validator.isValid(new URL("mailto:someone@example.com"), context));
    }
    
    @Test
    public void testHttpNoFragment() throws MalformedURLException {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Url>(Url.class).value(new String[]{"http", "https"}).attr("allowFragments", false).build());
      
       assertTrue(validator.isValid(new URL("http://localhost/"), context));
       assertTrue(validator.isValid(new URL("https://kth.se"), context));
       assertTrue(validator.isValid(new URL("http://kth.se//resource"), context));
       
       assertFalse(validator.isValid(new URL("http://kth.se/resource#anchor"), context));
       assertFalse(validator.isValid(new URL("file://users/rikardwi"), context));
       assertFalse(validator.isValid(new URL("mailto:someone@example.com"), context));
    }
}
