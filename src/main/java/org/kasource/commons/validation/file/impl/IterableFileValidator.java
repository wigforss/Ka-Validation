package org.kasource.commons.validation.file.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.file.File;

public class IterableFileValidator extends AbstractFileValidator implements ConstraintValidator<File, Iterable<? extends Object>> {

    @Override
    public void initialize(File annotation) {
       super.initialize(annotation);
    }
    
    @Override
    public boolean isValid(Iterable<? extends Object> value, ConstraintValidatorContext context) {        
        return isValid(value);
    }

}
