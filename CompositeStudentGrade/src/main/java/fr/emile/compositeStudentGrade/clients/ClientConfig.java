package fr.emile.compositeStudentGrade.clients;

import feign.Logger;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {
    @Bean
    Logger.Level feignLoggerLevel() {return Logger.Level.FULL;}

    @Bean
    public Logger logger(){return  new Slf4jLogger();}
}
