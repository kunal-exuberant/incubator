package likedriving.TechStacks.rmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RMQWriter {


    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);


        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        String exchangeName = "TestChannel";

        String routingKey = "TestRoutingKey";

        channel.exchangeDeclare("TestChannel", "direct", true);

        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, exchangeName, routingKey);


        byte [] messageBodyBytes = "Hello OLA !".getBytes();

        channel.basicPublish(exchangeName, routingKey, new AMQP.BasicProperties.Builder().expiration("5000").build(), messageBodyBytes);


        GetResponse response = channel.basicGet(queueName, false);
        if(response == null){
            System.out.println("No  messages retrived");
        }
        else{
            AMQP.BasicProperties properties = response.getProps();
            byte [] messageBody = response.getBody();
            System.out.println(properties.getTimestamp());
            System.out.println("Message count "+response.getMessageCount());
            System.out.println("Retrived message body "+ messageBody.toString());
        }
    }

}
