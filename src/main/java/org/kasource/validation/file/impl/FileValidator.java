package org.kasource.validation.file.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.file.File;

public class FileValidator extends AbstractFileValidator implements ConstraintValidator<File, String> {

    @Override
    public void initialize(File annotation) {
       super.initialize(annotation);
    }
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {        
        boolean isValid = isValid(value);
        if (!isValid) {
            setConstraintMessage(context);
        }
        return isValid;
    }

}
