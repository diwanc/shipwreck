package com.boot.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.jayway.service")
@EnableTransactionManagement
@Import({H2RepositoryConfig.class, MySqlRepositoryConfig.class})
public class ApplicationConfig {}