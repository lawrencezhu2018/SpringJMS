package xyz.cicy.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.cicy.consumer.config.ConsumerConfig;

public class AsyncConsumer
{
	private static final AsyncConsumer INSTANCE = new AsyncConsumer();

	private AsyncConsumer()
	{

	}

	public static AsyncConsumer getInstance()
	{
		return INSTANCE;
	}

	public static void main(String[] args)
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfig.class);

	}
}
