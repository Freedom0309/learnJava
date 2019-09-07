package com.freedom.rabbitmq.simpleQueue;

import com.freedom.rabbitmq.RabbitMQUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Copyright: Copyright (c) 2019 Asiainfo-Linkage
 *
 * @Description: 简单队列
 * @version:
 * @author: liufeng
 * @date: 20:23 2019/7/30
 * <p>
 * Modification History:
 * Date             Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/30 20:23  liufeng
 */
public class SimpleQueuePublish {
    private static final String SIMPLE_QUEUE = "simple_queue";

    public static void main(String[] args)
            throws IOException, TimeoutException {
        ConnectionFactory factory = RabbitMQUtils.getConnection();
        Connection connection = factory.newConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //创建隊列
        channel.queueDeclare(SIMPLE_QUEUE, false, false, false, null);
        String msg = "aaaaaaa I am tired";

        //发布消息
        channel.basicPublish("", SIMPLE_QUEUE, null, msg.getBytes());
        channel.close();
        connection.close();


    }
}
