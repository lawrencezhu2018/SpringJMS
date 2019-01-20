package xyz.cicy.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.cicy.server.config.ServerConfig;

public class Server
{
	public static void main(String[] args)
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(ServerConfig.class);
	}
}
