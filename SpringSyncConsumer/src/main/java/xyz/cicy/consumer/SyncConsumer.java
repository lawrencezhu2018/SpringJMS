package xyz.cicy.consumer;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

public class SyncConsumer
{
	private static final SyncConsumer INSTANCE = new SyncConsumer();

	private JmsTemplate jmsTemplate = new JmsTemplate(new ActiveMQConnectionFactory());

	private SyncConsumer()
	{
		jmsTemplate.setDefaultDestinationName("cc");
	}

	public static void main(String[] args)
	{
		SyncConsumer consumer = SyncConsumer.getInstance();
		System.out.println(consumer.receive().toString());
		System.out.println(consumer.receive().toString());

	}

	public static SyncConsumer getInstance()
	{
		return INSTANCE;
	}

	public Object receive()
	{
		return jmsTemplate.receiveAndConvert();
	}
}
