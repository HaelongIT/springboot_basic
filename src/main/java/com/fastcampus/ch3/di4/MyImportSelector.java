package com.fastcampus.ch3.di4;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        AnnotationAttributes attr = AnnotationAttributes.fromMap
                (importingClassMetadata.getAnnotationAttributes(EnableMyAutoCofiguration.class.getName(), false));
//        String mode = "test";
        String mode = attr.getString("value");
        if(mode.equals("test"))
            return new String[]{Config1.class.getName()};
        else
            return new String[]{Config2.class.getName()};
//        return new String[]{Config1.class.getName()};
    }
}
