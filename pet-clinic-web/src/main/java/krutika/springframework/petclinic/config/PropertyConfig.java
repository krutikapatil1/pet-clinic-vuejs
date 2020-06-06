package krutika.springframework.petclinic.config;

import krutika.springframework.petclinic.beans.MessageHlpr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Krutika Patil
 * @since : 6/5/2020, Fri
 **/
@Configuration
public class PropertyConfig {

    @Value("${welcome}")
    private String welcomeMsg;

    @Bean
    public MessageHlpr messageHelper() {
        MessageHlpr messageHelper = new MessageHlpr();
        messageHelper.setWelcomeMsg(welcomeMsg);
        return messageHelper;
    }
}
