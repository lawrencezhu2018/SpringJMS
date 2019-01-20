package xyz.cicy.server.config;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.remoting.JmsInvokerServiceExporter;
import xyz.cicy.server.student.StudentService;

@Configuration
@ComponentScan(basePackages = "xyz.cicy.*")
public class ServerConfig
{
	@Bean
	public JmsInvokerServiceExporter exporter(StudentService service)
	{
		JmsInvokerServiceExporter exporter = new JmsInvokerServiceExporter();
		exporter.setService(service);
		exporter.setServiceInterface(StudentService.class);

		return exporter;
	}

	@Bean
	public DefaultMessageListenerContainer defaultMessageListenerContainer(JmsInvokerServiceExporter exporter)
	{
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(new ActiveMQConnectionFactory());
		container.setMessageListener(exporter);
		container.setDestinationName("cc");

		return container;
	}
}
