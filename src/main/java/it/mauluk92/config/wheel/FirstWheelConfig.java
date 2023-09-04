package it.mauluk92.config.wheel;

import it.mauluk92.config.channel.first.FirstWheelChannelConfig;
import it.mauluk92.config.anomaly.AnomalyConfig;
import it.mauluk92.config.room.ControlRoomConfig;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.wheel.impl.FirstWheel;
import it.mauluk92.state.impl.LifeState;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@Import({AnomalyConfig.class, FirstWheelChannelConfig.class, ControlRoomConfig.class})
@IntegrationComponentScan(basePackages = {"it.mauluk92.gateway"})
@EnableIntegration
public class FirstWheelConfig {


    @Bean
    @Qualifier("firstWheel")
    public EntityOfFabularia firstWheel(@Qualifier("anomaly") EntityOfFabularia anomaly,
                                 @Qualifier("firstMachineChannel") MessageChannel firstMachineChannel,
                                 @Qualifier("secondMachineChannel") MessageChannel secondMachineChannel,
                                 @Qualifier("thirdMachineChannel") MessageChannel thirdMachineChannel,
                                        @Qualifier("masterWheel") EntityOfFabularia masterWheel,
                                        @Qualifier("firstControlRoom") EntityOfFabularia controlRoom){
        String description = "This is one of the farthest wheel of Fabularia...";
        Map<String, MessageChannel> fabricOfFirstWheel = new HashMap<>();
        fabricOfFirstWheel.put("firstMachineChannel", firstMachineChannel);
        fabricOfFirstWheel.put("secondMachineChannel", secondMachineChannel);
        fabricOfFirstWheel.put("thirdMachineChannel", thirdMachineChannel);
        FirstWheel wheel = new FirstWheel();
        wheel.setFabricOfTheWheel(fabricOfFirstWheel);
        LifeState lifeState = new LifeState();
        lifeState.setState(true);
        wheel.setLock(lifeState);
        wheel.setDescription(description);
        wheel.setChildren(List.of(anomaly, controlRoom));
        anomaly.setParent(wheel);
        masterWheel.setParent(masterWheel);
        masterWheel.getChildren().add(wheel);
        wheel.setParent(masterWheel);
        controlRoom.setParent(wheel);
        return wheel;
    }
}
