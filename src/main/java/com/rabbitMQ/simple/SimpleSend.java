package com.rabbitMQ.simple;

import java.io.IOException;

import com.rabbitMQ.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class SimpleSend {

	private static final String QUEUE_ONE = "test1";
	
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionUtils.getConnection();
		//获取通道
		Channel channel = con.createChannel();
		//创建队列声明
		channel.queueDeclare(QUEUE_ONE,false,false,false,null);
		
		String msg = "test send";
		channel.basicPublish("", QUEUE_ONE, null, msg.getBytes());
		
		System.out.println("--发送msg "+msg);
		channel.close();
		con.close();
	}
}
