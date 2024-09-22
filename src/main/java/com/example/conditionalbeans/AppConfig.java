package com.example.conditionalbeans;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyImportSelector.class)
public class AppConfig {
    // No additional code needed here
}
