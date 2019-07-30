package com.freedom.rabbitmq;

import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Copyright: Copyright (c) 2019 Asiainfo-Linkage
 *
 * @Description: TODO
 * @version:
 * @author: liufeng
 * @date: 20:04 2019/7/30
 * <p>
 * Modification History:
 * Date             Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/30 20:04  liufeng
 */
public class MqTest {
    private static final String SIMPLE_QUEUE = "simple_queue";

    @Test
    public void simpleQueuePublish() throws IOException, TimeoutException {
        ConnectionFactory factory = RabbitMQUtils.getConnection();
        Connection connection = factory.newConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //创建隊列
        channel.queueDeclare(SIMPLE_QUEUE, false, false, false, null);
        String msg = "aaaaaaa I am tired";

        channel.basicPublish("", SIMPLE_QUEUE, null, msg.getBytes());
        channel.close();
        connection.close();

    }

    @Test
    public void simpleQueueConsumer() throws IOException, TimeoutException {
        ConnectionFactory factory = RabbitMQUtils.getConnection();
        //创建通道
        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(SIMPLE_QUEUE, false, false, false, null);
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                    System.out.println(new String(body));
                }
            };
            channel.basicConsume(SIMPLE_QUEUE, true, consumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = RabbitMQUtils.getConnection();
        //创建通道
        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(SIMPLE_QUEUE, false, false, false, null);
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                    System.out.println(new String(body));
                }
            };
            channel.basicConsume(SIMPLE_QUEUE, true, consumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
