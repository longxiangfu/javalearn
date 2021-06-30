package com.spring.springboot.importExample;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ImportCImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.spring.springboot.importExample.ImportC", "com.spring.springboot.importExample.ImportB"};
    }
}
