package it.mauluk92.config.wheel;

import it.mauluk92.config.channel.second.SecondWheelChannelConfig;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.wheel.impl.SecondWheel;
import it.mauluk92.state.impl.LifeState;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.MessageChannel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Import({SecondWheelChannelConfig.class})
public class SecondWheelConfig {


    @Bean
    @Qualifier("secondWheel")
    public EntityOfFabularia secondWheel(@Qualifier("secondWheelLock")MessageChannel secondWheelLock,
                                         @Qualifier("masterWheel") EntityOfFabularia masterWheel){
        Map<String, MessageChannel> fabricOfSecondWheel = new HashMap<>();
        fabricOfSecondWheel.put("secondWheelLock", secondWheelLock);
        LifeState lifeState = new LifeState();
        lifeState.setState(false);
        SecondWheel secondWheel = new SecondWheel();
        secondWheel.setLock(lifeState);
        secondWheel.setDescription("Second Wheel");
        secondWheel.setChildren(new ArrayList<>());
        secondWheel.setParent(masterWheel);
        masterWheel.getChildren().add(secondWheel);
        secondWheel.setFabricOfTheWheel(fabricOfSecondWheel);
        return secondWheel;
    }
}
