package xyz.cicy.producer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import java.util.Date;

public class Producer
{
	private static final Producer INSTANCE = new Producer();


	private JmsTemplate jmsTemplate = new JmsTemplate();

	private Producer()
	{
		jmsTemplate.setConnectionFactory(new SingleConnectionFactory(new ActiveMQConnectionFactory()));
		jmsTemplate.setDefaultDestinationName("cc");
	}

	public static void main(String[] args)
	{
		Producer producer = Producer.getInstance();
		producer.send("Hello, cc!");
		producer.send(new Date());
	}

	public static Producer getInstance()
	{
		return INSTANCE;
	}

	public void send(String message)
	{
		jmsTemplate.convertAndSend(message);
	}

	public void send(Date date)
	{
		jmsTemplate.convertAndSend(date);
	}
}
