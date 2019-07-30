package com.freedom.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;

/**
 * Copyright: Copyright (c) 2019 Asiainfo-Linkage
 *
 * @Description: TODO
 * @version:
 * @author: liufeng
 * @date: 19:59 2019/7/30
 * <p>
 * Modification History:
 * Date             Author          Version            Description
 * ----------------------------------------------------------------------------------*
 * 2019/7/30 19:59  liufeng
 */
public class RabbitMQUtils {

    public static final ConnectionFactory getConnection(){

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.11.233");
        factory.setPort(5672);
        factory.setUsername("mqadmin");
        factory.setVirtualHost("/");
        factory.setPassword("mqadmin");
        return factory;
    }
}
