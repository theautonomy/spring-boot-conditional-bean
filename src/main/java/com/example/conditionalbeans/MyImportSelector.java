package com.example.conditionalbeans;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // Logic to choose which configuration class to import.
        return new String[] {MyConfiguration.class.getName()};
    }
}
