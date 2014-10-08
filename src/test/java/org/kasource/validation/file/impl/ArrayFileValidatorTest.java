package org.kasource.validation.file.impl;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.UUID;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorContext.ConstraintViolationBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;

import org.kasource.validation.file.File;
import org.kasource.validation.file.FileOperation;

import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class ArrayFileValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @Mock
    private ConstraintViolationBuilder builder;
        
    @TestedObject
    private ArrayFileValidator validator;
    
    
    @Test
    public void testExistingFile() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.file.File} {org.kasource.validation.file.FileOperation.EXISTING_FILE}")).andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<File>(File.class).value(FileOperation.EXISTING_FILE).build());
        String thisFile = ("src.test.java." + ArrayFileValidatorTest.class.getName()).replace('.', java.io.File.separatorChar) + ".java";
        thisFile = System.getProperty("user.dir") + java.io.File.separatorChar + thisFile;
        assertTrue(validator.isValid(new String[]{thisFile}, context));
        assertFalse(validator.isValid(new String[]{thisFile, UUID.randomUUID().toString()}, context));
    }
    
    @Test
    public void testExistingDirectory() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.file.File} {org.kasource.validation.file.FileOperation.EXISTING_DIRECTORY}")).andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<File>(File.class).value(FileOperation.EXISTING_DIRECTORY).build());
        assertTrue(validator.isValid(new String[]{System.getProperty("user.dir")}, context));
        assertFalse(validator.isValid(new String[]{System.getProperty("user.dir"), UUID.randomUUID().toString()}, context));
    }
    
    @Test
    public void testReadableFile() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.file.File} {org.kasource.validation.file.FileOperation.READABLE_FILE}")).andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<File>(File.class).value(FileOperation.READABLE_FILE).build());
        String thisFile = ("src.test.java." + ArrayFileValidatorTest.class.getName()).replace('.', java.io.File.separatorChar) + ".java";
        thisFile = System.getProperty("user.dir") + java.io.File.separatorChar + thisFile;
        assertTrue(validator.isValid(new String[]{thisFile}, context));
        assertFalse(validator.isValid(new String[]{thisFile, UUID.randomUUID().toString()}, context));
    }
    
    @Test
    public void testWritableFile() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.file.File} {org.kasource.validation.file.FileOperation.WRITABLE_FILE}")).andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<File>(File.class).value(FileOperation.WRITABLE_FILE).build());
        String thisFile = ("src.test.java." + ArrayFileValidatorTest.class.getName()).replace('.', java.io.File.separatorChar) + ".java";
        thisFile = System.getProperty("user.dir") + java.io.File.separatorChar + thisFile;
        assertTrue(validator.isValid(new String[]{thisFile}, context));
        assertFalse(validator.isValid(new String[]{thisFile, UUID.randomUUID().toString()}, context));
    }
    
    @Test
    public void testWritableExistingFile() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.file.File} {org.kasource.validation.file.FileOperation.WRITABLE_EXISTING_FILE}")).andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<File>(File.class).value(FileOperation.WRITABLE_EXISTING_FILE).build());
        String thisFile = ("src.test.java." + ArrayFileValidatorTest.class.getName()).replace('.', java.io.File.separatorChar) + ".java";
        thisFile = System.getProperty("user.dir") + java.io.File.separatorChar + thisFile;
        assertTrue(validator.isValid(new String[]{thisFile}, context));
        assertFalse(validator.isValid(new String[]{thisFile, UUID.randomUUID().toString()}, context));
    }
    
    @Test
    public void testExecutableFile() {
        context.disableDefaultConstraintViolation();
        expectLastCall();
        expect(context.buildConstraintViolationWithTemplate("{org.kasource.validation.file.File} {org.kasource.validation.file.FileOperation.EXECUTABLE_FILE}")).andReturn(builder);
        expect(builder.addConstraintViolation()).andReturn(context);
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<File>(File.class).value(FileOperation.EXECUTABLE_FILE).build());
        String javaExecutable = System.getProperty("java.home") + java.io.File.separator + "bin" + java.io.File.separator + "java";
        assertTrue(validator.isValid(new String[]{javaExecutable}, context));
        assertFalse(validator.isValid(new String[]{javaExecutable, UUID.randomUUID().toString()}, context));
    }
}
