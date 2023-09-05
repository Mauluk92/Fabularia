package it.mauluk92.config.wheel;

import it.mauluk92.config.channel.second.SecondWheelChannelConfig;
import it.mauluk92.config.router.SecondWheelRouter;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.wheel.impl.SecondWheel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.MessageChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
@Import({SecondWheelRouter.class})
public class SecondWheelConfig {


    @Bean
    @Qualifier("secondWheel")
    public EntityOfFabularia secondWheel(@Qualifier("secondWheelRouter") Map<String, MessageChannel> secondWheelRouter){
        SecondWheel secondWheel = new SecondWheel();
        secondWheel.setDescription("Second Wheel");
        secondWheel.setFabricOfTheWheel(secondWheelRouter);
        return secondWheel;
    }

    @Bean
    @Qualifier("secondWheelChildren")
    public List<EntityOfFabularia> secondWheelChildren(){
        return new ArrayList<>();
    }
}
