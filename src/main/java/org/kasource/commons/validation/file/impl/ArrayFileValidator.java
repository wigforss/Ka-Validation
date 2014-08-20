package org.kasource.commons.validation.file.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.commons.validation.file.File;

public class ArrayFileValidator extends AbstractFileValidator implements ConstraintValidator<File, Object[]> {

    @Override
    public void initialize(File annotation) {
       super.initialize(annotation);
    }
    
    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {        
        return isValidArray(value);
    }

}
