package org.kasource.validation.xml.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.xml.Jaxb;

public class JaxbValidator extends AbstractJaxbValidator  implements ConstraintValidator<Jaxb, String>  {
    @Override
    public void initialize(Jaxb annotation) {
       super.initialize(annotation.value()); 
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {       
        return isValid(value);
    }
}
