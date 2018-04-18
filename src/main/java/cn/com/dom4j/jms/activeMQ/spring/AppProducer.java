package cn.com.dom4j.jms.activeMQ.spring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

public class AppProducer {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:activemq/producer.xml");


        ProducerService producerService = context.getBean(ProducerService.class);

        for (int i = 0; i < 100; i++) {
            producerService.sendMessage("spring-test: " + i);
        }

        context.close();


    }


}
