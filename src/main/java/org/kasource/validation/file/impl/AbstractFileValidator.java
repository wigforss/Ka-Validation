package org.kasource.validation.file.impl;

import java.io.File;

import javax.validation.ConstraintValidatorContext;

import org.kasource.validation.AbstractValidator;
import org.kasource.validation.file.FileOperation;

public abstract class AbstractFileValidator extends AbstractValidator {
    
    private FileOperation fileOperation;
    
    protected void initialize(org.kasource.validation.file.File annotation) {
        fileOperation = annotation.value();
    }
    
    @Override
    protected boolean isValid(Object object) {
        if (object == null) {
            return true;
        }
        File file = null;
        if (object instanceof File) {
            file = (File) object;
        } else {
            file = new File(object.toString());
        }
        
        if (!fileOperation.getFilter().accept(file)) {
            return false;
        }
        
        return true;
    }
    
    protected void setConstraintMessage(ConstraintValidatorContext context) {    
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("{org.kasource.validation.file.File} {" + fileOperation.getMessageKey() +"}").addConstraintViolation();    
    }
}
