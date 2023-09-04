package it.mauluk92.config.net;

import it.mauluk92.config.channel.first.FirstWheelChannelConfig;
import it.mauluk92.config.channel.second.SecondWheelChannelConfig;
import it.mauluk92.config.wheel.FirstWheelConfig;
import it.mauluk92.config.wheel.SecondWheelConfig;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.net.MasterWheel;
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
@Import({FirstWheelConfig.class,
        SecondWheelConfig.class,
        FirstWheelChannelConfig.class,
        SecondWheelChannelConfig.class,
})
public class NetOfWheelsConfig {

    @Bean
    @Qualifier("masterWheel")
    public EntityOfFabularia masterWheel(@Qualifier("firstWheelChannel")MessageChannel firstWheelChannel,
                                         @Qualifier("secondWheelChannel") MessageChannel secondWheelChannel,
                                         @Qualifier("soulChannel") MessageChannel soulChannel,
                                         @Qualifier("reverseSoulChannel") MessageChannel reverseSoulChannel){
        Map<String, MessageChannel> fabricOfFabularia = new HashMap<>();
        fabricOfFabularia.put("firstWheelChannel", firstWheelChannel);
        fabricOfFabularia.put("secondWheelChannel", secondWheelChannel);
        fabricOfFabularia.put("soulChannel", soulChannel);
        fabricOfFabularia.put("reverseSoulChannel", reverseSoulChannel);
        MasterWheel wheel = new MasterWheel(fabricOfFabularia);
        wheel.setParent(wheel);
        LifeState state = new LifeState();
        state.setState(true);
        wheel.setLock(state);
        wheel.setChildren(new ArrayList<>());
        wheel.setDescription("This is the master wheel of Fabularia");
        return wheel;
    }
}
