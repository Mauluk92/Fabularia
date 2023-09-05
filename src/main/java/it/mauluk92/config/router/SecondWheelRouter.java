package it.mauluk92.config.router;

import it.mauluk92.config.channel.second.SecondWheelChannelConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.MessageChannel;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Import(SecondWheelChannelConfig.class)
public class SecondWheelRouter {

    @Bean
    @Qualifier("secondWheelRouter")
    public Map<String, MessageChannel> secondWheelRouter(@Qualifier("secondWheelLock")MessageChannel secondWheelLock){
        Map<String, MessageChannel> router = new HashMap<>();
        router.put("secondWheelLock", secondWheelLock);
        return router;

    }
}
