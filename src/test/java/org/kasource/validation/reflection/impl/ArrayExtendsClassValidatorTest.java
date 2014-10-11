package org.kasource.validation.reflection.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.management.AttributeList;
import javax.validation.ConstraintValidatorContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kasource.commons.reflection.annotation.AnnotationBuilder;
import org.kasource.validation.reflection.ExtendsClass;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.easymock.annotation.Mock;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class ArrayExtendsClassValidatorTest {
    @Mock
    private ConstraintValidatorContext context;
    
    @TestedObject
    private ArrayExtendsClassValidator validator;

    @Test
    public void testImplements() {
     
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<ExtendsClass>(ExtendsClass.class).value(List.class).build());

        assertTrue(validator.isValid(new String[]{"java.util.ArrayList", "java.util.LinkedList"}, context));
        
        assertFalse(validator.isValid(new String[]{"java.util.ArrayList", "java.lang.String"}, context));
        assertFalse(validator.isValid(new String[]{"java.util.ArrayList", "qwe.ewqqwe.Ghhjlkj"}, context));
    }
    
    
    @Test
    public void testExtends() {
     
        EasyMockUnitils.replay();
        validator.initialize(new AnnotationBuilder<ExtendsClass>(ExtendsClass.class).value(ArrayList.class).build());

        assertTrue(validator.isValid(new Class[]{AttributeList.class}, context));
        
        assertFalse(validator.isValid(new Class[]{AttributeList.class, String.class}, context));
       
    }

}
