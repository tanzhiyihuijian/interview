package cn.com.dom4j.jms.activeMQ.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AppProducer {

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

            // 6. 创建一个生产者
            MessageProducer producer = session.createProducer(destination);

            // 7. 向目标发送消息
            for (int i = 0; i < 100; i++) {
                // 创建消息
                TextMessage message = session.createTextMessage("test-" + i);
                // 发送消息
                producer.send(message);

                System.out.println("发送消息: " + message.getText());
            }

            // 8. 关闭连接
            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }


    }


}
