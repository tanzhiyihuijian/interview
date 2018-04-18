package cn.com.dom4j.jms.activeMQ.spring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class AppConsumer {

    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:activemq/consumer.xml");




    }

}
