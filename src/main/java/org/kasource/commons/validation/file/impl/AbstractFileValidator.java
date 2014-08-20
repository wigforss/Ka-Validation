package org.kasource.commons.validation.file.impl;

import java.io.File;

import org.kasource.commons.validation.AbstractValidator;
import org.kasource.commons.validation.file.FileOperation;

public abstract class AbstractFileValidator extends AbstractValidator {
    
    private FileOperation[] fileOperations;
    
    protected void initialize(org.kasource.commons.validation.file.File annotation) {
        fileOperations = annotation.value();
    }
    
    @Override
    protected boolean isValid(Object object) {
        if (object == null) {
            return true;
        }
        File file = new File(object.toString());
        for (FileOperation fileOperation : fileOperations) {
            if (!fileOperation.getFilter().accept(file)) {
                return false;
            }
        }
        return true;
    }
}
