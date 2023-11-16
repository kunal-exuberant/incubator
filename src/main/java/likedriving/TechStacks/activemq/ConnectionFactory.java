package likedriving.TechStacks.activemq;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class ConnectionFactory {

    public static void connect(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        try {
            Connection connection = activeMQConnectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination queue = session.createQueue("ACTIVEMQ-1");

            MessageProducer producer = session.createProducer(queue);
            TextMessage message = session.createTextMessage("Hi Tech stack Implementation of activeMQ");
            System.out.println(message);
            producer.send(message);

            MessageConsumer consumer = session.createConsumer(queue);
            Message message1 = consumer.receive(1000);
            System.out.println(message1);

            session.close();
            connection.close();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        connect();
    }

}
