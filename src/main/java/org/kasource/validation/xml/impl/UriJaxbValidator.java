package org.kasource.validation.xml.impl;

import java.net.URI;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.xml.Jaxb;

public class UriJaxbValidator extends AbstractJaxbValidator  implements ConstraintValidator<Jaxb, URI>  {
    @Override
    public void initialize(Jaxb annotation) {
       super.initialize(annotation.value()); 
    }
    
    @Override
    public boolean isValid(URI value, ConstraintValidatorContext context) {       
        return isValid(value);
    }
}
