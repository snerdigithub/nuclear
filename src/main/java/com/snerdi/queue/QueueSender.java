package com.snerdi.queue;

import java.io.Serializable;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.alibaba.fastjson.JSON;
import com.snerdi.dao.QueueDao;
import com.snerdi.po.RCSPressBBean;

public class QueueSender {

	
	public void sendMessageJSON(String queueName,Object obj){
		Connection connection = null;
		Session session = null;
		try{
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
			connection = connectionFactory.createConnection();
			connection.start();
			
			session =  connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Destination destination =  session.createQueue(queueName);
			MessageProducer producer = session.createProducer(destination);
			
			String jsonString = JSON.toJSONString(obj);
			
			TextMessage message = session.createTextMessage(jsonString);
			System.out.println(jsonString+"插入队列");
			producer.send(message);
			session.commit();
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
	
	
	public void sendMessageTxt(String queueName,String val){
		Connection connection = null;
		Session session = null;
		try{
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
			connection = connectionFactory.createConnection();
			connection.start();
			
			session =  connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Destination destination =  session.createQueue(queueName);
			MessageProducer producer = session.createProducer(destination);
			TextMessage message = session.createTextMessage(val);
			producer.send(message);
			session.commit();
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
	
	
	public static void main(String[] args)  {
		QueueSender qs = new QueueSender();
		//消息队列初始化ZGSLL
//		List list1 = new QueueDao().listZGSLL();
//		for(int i=0;i<list1.size();i++){
//			System.out.println("数值："+list1.get(i).toString()+"插入队列ZGSLL");
//			qs.sendMessageTxt("ZGSLL",list1.get(i).toString());
//			
//		}
		//消息队列初始化
		List list2 = new QueueDao().listDCSData();
		for(int i=0;i<list2.size();i++){
			qs.sendMessageJSON("DCSData",list2.get(i));
			
		}	
		
		
		
	}

}
