package it.mauluk92.config.channel.master;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class MasterWheelChannelConfig {

    @Bean
    @Qualifier("masterWheelChannel")
    public MessageChannel masterWheelChannel(){
        return new DirectChannel();
    }
}
