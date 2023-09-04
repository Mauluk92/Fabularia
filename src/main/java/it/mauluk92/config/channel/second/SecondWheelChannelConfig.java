package it.mauluk92.config.channel.second;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class SecondWheelChannelConfig {


    @Bean
    @Qualifier("secondWheelChannel")
    public MessageChannel secondWheelChannel(){
        return new DirectChannel();
    }

    @Bean
    @Qualifier("secondWheelLock")
    public MessageChannel secondWheelLock(){return new DirectChannel();}
}
