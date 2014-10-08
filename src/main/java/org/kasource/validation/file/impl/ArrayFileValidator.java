package org.kasource.validation.file.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.file.File;

public class ArrayFileValidator extends AbstractFileValidator implements ConstraintValidator<File, Object[]> {

    @Override
    public void initialize(File annotation) {
       super.initialize(annotation);
    }
    
    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext context) {        
        boolean isValid = isValidArray(value);
        if (!isValid) {
            setConstraintMessage(context);
        }
        return isValid;
    }

}
