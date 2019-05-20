package com.rabbitMQ.util;

import java.io.IOException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtils {

	/**
	 * 获取链接的工具类
	 * @return
	 * @throws IOException
	 */
	public static Connection getConnection() throws IOException{
		//定义一个链接工厂
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.0.1");
		factory.setPort(5672);
		factory.setVirtualHost("/test");
		factory.setUsername("admin");
		factory.setPassword("123");
		return factory.newConnection();
	}
}
