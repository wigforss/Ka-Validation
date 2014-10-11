package org.kasource.validation.url.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.net.URI;
import java.net.URISyntaxException;


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
public class URIUrlValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private URIUrlValidator validator;
    
    @Test
    public void testAnyProtocol() throws URISyntaxException {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Url>(Url.class).build());
       
       assertTrue(validator.isValid(new URI("http://kth.se#anchor"), context));
       assertTrue(validator.isValid(new URI("file://users/rikardwi"), context));
       assertFalse(validator.isValid(new URI("mailto:someone@example.com"), context));
    }
    
    @Test
    public void testHttpProtocol() throws URISyntaxException {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Url>(Url.class).value(new String[]{"http", "https"}).build());
       
       assertTrue(validator.isValid(new URI("http://kth.se//resource#anchor"), context));
       assertTrue(validator.isValid(new URI("https://kth.se"), context));
       assertTrue(validator.isValid(new URI("http://localhost/"), context));
       assertFalse(validator.isValid(new URI("file://users/rikardwi"), context));
       assertFalse(validator.isValid(new URI("mailto:someone@example.com"), context));
    }
    
    @Test
    public void testHttpNoDoubleSlahses() throws URISyntaxException {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Url>(Url.class).value(new String[]{"http", "https"}).attr("allowTwoSlahes", false).build());
       assertTrue(validator.isValid(new URI("http://localhost/"), context));
       assertTrue(validator.isValid(new URI("http://kth.se/resource#anchor"), context));
       assertTrue(validator.isValid(new URI("https://kth.se"), context));
       assertFalse(validator.isValid(new URI("http://kth.se//resource"), context));
       assertFalse(validator.isValid(new URI("file://users/rikardwi"), context));
       assertFalse(validator.isValid(new URI("mailto:someone@example.com"), context));
    }
    
    @Test
    public void testHttpNoLocal() throws URISyntaxException {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Url>(Url.class).value(new String[]{"http", "https"}).attr("allowLocalUrls", false).build());
      
       assertTrue(validator.isValid(new URI("http://kth.se/resource#anchor"), context));
       assertTrue(validator.isValid(new URI("https://kth.se"), context));
       assertTrue(validator.isValid(new URI("http://kth.se//resource"), context));
       assertFalse(validator.isValid(new URI("http://localhost/"), context));
       assertFalse(validator.isValid(new URI("file://users/rikardwi"), context));
       assertFalse(validator.isValid(new URI("mailto:someone@example.com"), context));
    }
    
    @Test
    public void testHttpNoFragment() throws URISyntaxException {
       EasyMockUnitils.replay();
       validator.initialize(new AnnotationBuilder<Url>(Url.class).value(new String[]{"http", "https"}).attr("allowFragments", false).build());
      
       assertTrue(validator.isValid(new URI("http://localhost/"), context));
       assertTrue(validator.isValid(new URI("https://kth.se"), context));
       assertTrue(validator.isValid(new URI("http://kth.se//resource"), context));
       
       assertFalse(validator.isValid(new URI("http://kth.se/resource#anchor"), context));
       assertFalse(validator.isValid(new URI("file://users/rikardwi"), context));
       assertFalse(validator.isValid(new URI("mailto:someone@example.com"), context));
    }
}
