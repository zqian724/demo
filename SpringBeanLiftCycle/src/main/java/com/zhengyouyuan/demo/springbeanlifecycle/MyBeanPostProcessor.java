package com.zhengyouyuan.demo.springbeanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor, InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (!beanName.equals("helloBean")){
            return null;
        }
        System.out.println("=====> postProcessBeforeInstantiation invoke, order 2 ");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (!beanName.equals("helloBean")){
            return true;
        }
        System.out.println("=====> postProcessAfterInstantiation invoke, order 4 ");
        return true;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (!beanName.equals("helloBean")){
            return pvs;
        }
        System.out.println("=====> postProcessProperties invoke, order 5 ");
        return null;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (!beanName.equals("helloBean")){
            return pvs;
        }
        System.out.println("=====> postProcessPropertyValues invoke, order 6 ");
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (!beanName.equals("helloBean")){
            return bean;
        }
        System.out.println("=====> postProcessBeforeInitialization invoke, name=" + beanName + ", order 12 ");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!beanName.equals("helloBean")){
            return bean;
        }
        System.out.println("=====> postProcessAfterInitialization invoke, name=" + beanName + ", order 15 ");
        return bean;
    }
}
