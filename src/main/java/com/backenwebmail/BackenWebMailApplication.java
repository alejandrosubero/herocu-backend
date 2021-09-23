package com.backenwebmail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackenWebMailApplication {

	protected static final Log logger = LogFactory.getLog(BackenWebMailApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackenWebMailApplication.class, args);

		logger.info("the document  Swagger is in link: ==>  http://localhost:1111/swagger-ui.html");
	}

}
