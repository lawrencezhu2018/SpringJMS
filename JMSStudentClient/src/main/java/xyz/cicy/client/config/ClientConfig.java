package xyz.cicy.client.config;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.remoting.JmsInvokerProxyFactoryBean;
import xyz.cicy.server.student.StudentService;

@Configuration
@ComponentScan(basePackages = "xyz.cicy.client.*")
public class ClientConfig
{
	@Bean
	public JmsInvokerProxyFactoryBean proxy()
	{
		JmsInvokerProxyFactoryBean proxy = new JmsInvokerProxyFactoryBean();
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();

		factory.setTrustAllPackages(true);
		proxy.setServiceInterface(StudentService.class);
		proxy.setConnectionFactory(factory);
		proxy.setQueueName("cc");

		return proxy;
	}

	@Bean(name = "studentService")
	public StudentService studentService(StudentService service)
	{
		System.out.println(service);
		return service;
	}
}
