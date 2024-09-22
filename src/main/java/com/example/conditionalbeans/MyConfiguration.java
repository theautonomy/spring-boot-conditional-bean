package com.example.conditionalbeans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class MyConfiguration implements BeanDefinitionRegistryPostProcessor, EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
            throws BeansException {
        if ("A".equals(environment.getProperty("my.service.type"))) {
            registerBean(registry, "serviceA", ServiceA.class);
        } else if ("B".equals(environment.getProperty("my.service.type"))) {
            registerBean(registry, "serviceB", ServiceB.class);
        }
    }

    private void registerBean(
            BeanDefinitionRegistry registry, String beanName, Class<?> beanClass) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
    }

    @Override
    public void postProcessBeanFactory(
            org.springframework.beans.factory.config.ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        // No further processing required
    }
}
