package com.digitalinnovationone.springboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {

        private String driverClassName;
        private String url;
        private String username;
        private String password;

        @Profile("dev")
        @Bean
        public String testDataBaseConnection(){
            System.out.println("DB connection for DEV - H2");
            System.out.println(driverClassName);
            System.out.println(url);
            return "DB connection to H2_TEST - test instance";
        }

        @Profile("prod")
        @Bean
        public String productionDataBaseConnection(){
            System.out.println("DB Connection in Production");
            System.out.println(driverClassName);
            System.out.println(url);
            return "DB connection to MYSQL_PROD - test instance";
        }


}
