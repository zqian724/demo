package com.zhengyouyuan.demo.springbeanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@RestController("helloBean")
@RequestMapping("/hello")
public class Hello  implements
        BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        InitializingBean,
        DisposableBean {

    private HelloService service;

    @Autowired
    public void setService(HelloService service) {
        System.out.println("=====> bean field inject, order 8");
        this.service = service;
    }

    private String value;

    @Value("lifestyle.value")
    public void setValue(String value) {
        System.out.println("=====> value field inject, order 7");
        this.value = value;
    }

    public Hello() {
        System.out.println("=====> hello constructor, order 3");
    }

    @GetMapping(produces = "application/json;charset=UTF-8, text/plain;charset=UTF-8")
    public String hello(){
        if (value != null){
            return value;
        }
        int i = service.hashCode();
        return "hello, " + i;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("=====> setBeanName invoke, name=" + s + ", order 9 ");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("=====> setBeanFactory invoke, order 10 ");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("=====> setApplicationContext invoke, order 11 ");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("=====> afterPropertiesSet invoke, order 14 ");

    }

    @Override
    public void destroy(){
        System.out.println("=====> destroy invoke, order 17 ");
    }


    @PostConstruct
    public void PostConstruct(){
        System.out.println("=====> PostConstruct invoke, order 13 ");
    }

    @PreDestroy
    public void PreDestroy(){
        System.out.println("=====> PreDestroy invoke, order 16 ");
    }
}
