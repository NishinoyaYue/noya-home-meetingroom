package com.rabbitMQ.simple;

import java.io.IOException;

import com.rabbitMQ.util.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;

public class Recv {

	private static final String QUEUE_TEST="test1";
	
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionUtils.getConnection();
		Channel channel = con.createChannel();
		channel.queueDeclare(QUEUE_TEST, false, false, false, null);
		
		DefaultConsumer consumer = new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag, com.rabbitmq.client.Envelope envelope, 
					com.rabbitmq.client.AMQP.BasicProperties properties, byte[] body) throws IOException {
				
				String msgStr = new String(body,"utf-8");
				System.out.println("new api recv:"+msgStr);
			}
		};
		//监听队列
		channel.basicConsume(QUEUE_TEST, true,consumer);

		
		
	}
}
