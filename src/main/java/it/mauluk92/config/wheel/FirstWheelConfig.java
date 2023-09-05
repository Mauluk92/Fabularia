package it.mauluk92.config.wheel;

import it.mauluk92.config.anomaly.AnomalyConfig;
import it.mauluk92.config.room.ControlRoomConfig;
import it.mauluk92.config.router.FirstWheelRouter;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.wheel.impl.FirstWheel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.MessageChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
@Import({FirstWheelRouter.class, AnomalyConfig.class, ControlRoomConfig.class})
public class FirstWheelConfig {


    @Bean
    @Qualifier("firstWheel")
    public EntityOfFabularia firstWheel(@Qualifier("firstWheelRouter") Map<String, MessageChannel> router
                                        ){
        String description = "This is one of the farthest wheel of Fabularia...";
        FirstWheel wheel = new FirstWheel();
        wheel.setFabricOfTheWheel(router);
        wheel.setDescription(description);
        return wheel;
    }

    @Bean
    @Qualifier("firstWheelChildren")
    List<EntityOfFabularia> firstWheelChildren(@Qualifier("anomaly") EntityOfFabularia anomaly,
                                               @Qualifier("firstControlRoom") EntityOfFabularia controlRoom){
        List<EntityOfFabularia> children = new ArrayList<>();
        children.add(anomaly);
        children.add(controlRoom);
        return children;

    }
}
