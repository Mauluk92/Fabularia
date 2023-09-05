package it.mauluk92.config.wheel;

import it.mauluk92.config.router.MasterWheelRouter;
import it.mauluk92.net.MasterWheel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.MessageChannel;

import java.util.Map;

@Configuration
@Import(MasterWheelRouter.class)
public class MasterWheelConfig {

    @Bean
    @Qualifier("masterWheel")
    public MasterWheel masterWheel(@Qualifier("masterWheelRouter")Map<String, MessageChannel> masterWheelRouter){
        MasterWheel masterWheel = new MasterWheel(masterWheelRouter);
        String description = "The central wheel of Fabularia where everything branches out";
        masterWheel.setDescription(description);
        return masterWheel;
    }
}
