package it.mauluk92.config.router;

import it.mauluk92.config.channel.master.MasterWheelChannelConfig;
import it.mauluk92.net.MasterWheel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.MessageChannel;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Import(MasterWheelChannelConfig.class)
public class MasterWheelRouter {



    @Bean
    @Qualifier("masterWheelRouter")
    public Map<String, MessageChannel> masterWheelRouter(@Qualifier("firstWheelChannel")MessageChannel firstWheelChannel,
                                                         @Qualifier("secondWheelChannel") MessageChannel secondWheelChannel,
                                                         @Qualifier("soulChannel") MessageChannel soulChannel,
                                                         @Qualifier("reverseSoulChannel") MessageChannel reverseSoulChannel){
        Map<String, MessageChannel> router = new HashMap<>();
        router.put("firstWheelChannel", firstWheelChannel);
        router.put("secondWheelChannel", secondWheelChannel);
        router.put("soulChannel", soulChannel);
        router.put("reverseSoulChannel", reverseSoulChannel);
        return router;
    }
}
