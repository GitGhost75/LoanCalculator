package org.kiemle.configuration;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@org.springframework.boot.test.context.TestConfiguration
public class TestConfiguration {

	@Bean
	@ServiceConnection
	public PostgreSQLContainer getPostgresContainer() {
		return new PostgreSQLContainer(DockerImageName.parse("postgres:latest"));
	}
}
