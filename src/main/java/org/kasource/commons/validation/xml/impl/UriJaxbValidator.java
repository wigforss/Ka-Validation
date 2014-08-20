package org.kasource.commons.validation.xml.impl;

import java.net.URI;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.xml.Jaxb;

public class UriJaxbValidator extends AbstractJaxbValidator  implements ConstraintValidator<Jaxb, URI>  {
    @Override
    public void initialize(Jaxb annotation) {
       super.initialize(annotation.value(), annotation.location()); 
    }
    
    @Override
    public boolean isValid(URI value, ConstraintValidatorContext context) {       
        return isValid(value);
    }
}
