package com.freedom.rabbitmq.simpleQueue;

import com.freedom.rabbitmq.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Copyright: Copyright (c) 2019 Asiainfo-Linkage
 *
 * @Description: TODO
 * @version:
 * @author: liufeng
 * @date: 20:25 2019/7/30
 * <p>
 * Modification History:
 * Date             Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/30 20:25  liufeng
 */
public class SimpleQueueConsumer {
    private static final String SIMPLE_QUEUE = "simple_queue";

    public static void main(String[] args) {
        ConnectionFactory factory = RabbitMQUtils.getConnection();
        //创建通道
        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(SIMPLE_QUEUE, false, false, false, null);
            //监听队列，处理消息
            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                    System.out.println(new String(body));
                }
            };
            //连接队列进行消费
            channel.basicConsume(SIMPLE_QUEUE, true, consumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
