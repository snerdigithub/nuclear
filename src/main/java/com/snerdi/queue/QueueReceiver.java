package com.snerdi.queue;

import java.lang.reflect.Member;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.snerdi.po.DCSDataBean;

public class QueueReceiver {

	
	/**
	 * 
	 * @param queueName
	 * @param interval
	 */
	public void receiveMessage(String queueName){
		Connection connection = null;
		Session session = null;
		try{
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
			connection = connectionFactory.createConnection();
			connection.start();
			
			session =  connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Destination destination =  session.createQueue(queueName);
			MessageConsumer consumer = session.createConsumer(destination);
			TextMessage message = (TextMessage)consumer.receive();
			session.commit();
			System.out.println(message.getText());
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public ObjectMessage receiveObjectMessage(String queueName){
		Connection connection = null;
		Session session = null;
		ObjectMessage message = null;
		try{
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
			connection = connectionFactory.createConnection();
			connection.start();
			
			session =  connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Destination destination =  session.createQueue(queueName);
			MessageConsumer consumer = session.createConsumer(destination);
			message = (ObjectMessage)consumer.receive();
			session.commit();
			System.out.println(message.getStringProperty("timeStamp"));
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return message;
	}
	
	
	public static void main(String[] args) throws JMSException {
		ObjectMessage m = new QueueReceiver().receiveObjectMessage("DCSData");
        Member dcs = (Member)m.getObject();
		System.out.println(dcs.getName());

	}

}
