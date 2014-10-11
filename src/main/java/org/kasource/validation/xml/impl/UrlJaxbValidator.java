package org.kasource.validation.xml.impl;

import java.net.URL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.xml.Jaxb;

public class UrlJaxbValidator extends AbstractJaxbValidator  implements ConstraintValidator<Jaxb, URL>  {
    @Override
    public void initialize(Jaxb annotation) {
       super.initialize(annotation.value()); 
    }
    
    @Override
    public boolean isValid(URL value, ConstraintValidatorContext context) {       
        return isValid(value);
    }
}
