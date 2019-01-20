package xyz.cicy.consumer.config;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

@Configuration
@ComponentScan(basePackages = "xyz.cicy.*")
public class ConsumerConfig
{

	@Bean
	public MessageListenerContainer messageListenerContainer(MessageListener messageListener)
	{
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		ConnectionFactory connectionFactory = new SingleConnectionFactory(new ActiveMQConnectionFactory());
		container.setConnectionFactory(connectionFactory);
		container.setDestinationName("cc");
		container.setMessageListener(messageListener);

		return container;
	}
}
