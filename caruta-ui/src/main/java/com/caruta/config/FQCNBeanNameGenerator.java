package com.caruta.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

public class FQCNBeanNameGenerator extends AnnotationBeanNameGenerator {

  @Override
  public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
    return super.generateBeanName(definition, registry);
  }

  @Override
  protected String buildDefaultBeanName(BeanDefinition definition) {
    return definition.getBeanClassName();
  }
}
