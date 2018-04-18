package cn.com.dom4j.jms.activeMQ.spring;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

public class ProducerServiceImpl implements ProducerService {

    @Resource
    private JmsTemplate jmsTemplate;

    // 队列目的地
    // @Resource(name = "queueDestination")

    // 主题目的地
    @Resource(name = "topicDestination")
    private Destination destination;


    public void sendMessage(final String message) {

        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
        System.out.println("发送消息: " + message);

    }
}
