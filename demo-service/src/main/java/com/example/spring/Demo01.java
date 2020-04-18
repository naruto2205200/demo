package com.example.spring;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author naruto
 * @data 2019/4/16.
 */
public class Demo01 {

    public static void main(String[] args) {
        BeanFactory beanFactory= new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("springBeanTest/beans.xml");
        factory.getBean("");

    }
}
