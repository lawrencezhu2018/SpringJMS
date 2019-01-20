package xyz.cicy.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.cicy.client.config.ClientConfig;
import xyz.cicy.server.student.StudentService;

public class Client
{
	private static final Client INSTANCE = new Client();
	@Autowired
	private StudentService service;

	private Client()
	{

	}

	public static Client getInstance()
	{
		return INSTANCE;
	}

	public static void main(String[] args)
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(ClientConfig.class);
		StudentService service = (StudentService) context.getBean("studentService");
		System.out.println(service.findScore("cc"));
	}

	public double findScore(String name)
	{
		return service.findScore(name);
	}
}
