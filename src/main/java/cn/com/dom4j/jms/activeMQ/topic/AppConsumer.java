package cn.com.dom4j.jms.activeMQ.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AppConsumer {

    private static final String url = "tcp://118.89.50.50:61616";
    private static final String topicName = "queue-test";

    public static void main(String[] args) {


        // 1. 创建 ConnectionFactory
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);

        try {

            // 2. 创建 Connection
            Connection connection = factory.createConnection();

            // 3. 启动连接
            connection.start();

            // 4. 创建回话 (arg0: 是否开启事务, arg1: 回话应答模式)
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // 5. 创建一个目标
            Destination destination = session.createTopic(topicName);

            // 6. 创建一个消费者
            MessageConsumer consumer = session.createConsumer(destination);

            // 7. 创建一个监听器
            consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage) message;
                    try {
                        System.out.println("接收消息: " + textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });


        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
