package com.yichen.jvmstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JvmStudyApplication {

	private static String[] args;
	private static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		JvmStudyApplication.args = args;
		JvmStudyApplication.context = SpringApplication.run(JvmStudyApplication.class, args);
	}

	public static void restart() {
		// close previous context
		context.close();

		// and build new one
		JvmStudyApplication.context = SpringApplication.run(JvmStudyApplication.class, args);

	}

}
