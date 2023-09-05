package it.mauluk92.config.router;

import it.mauluk92.config.channel.first.FirstWheelChannelConfig;
import it.mauluk92.config.discourse.FirstAnomalyActionsConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.MessageChannel;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Import({FirstWheelChannelConfig.class})
public class FirstWheelRouter {

    @Bean
    @Qualifier("firstWheelRouter")
    public Map<String, MessageChannel> firstWheelRouter(@Qualifier("firstMachineChannel") MessageChannel firstMachineChannel,
                                                        @Qualifier("secondMachineChannel") MessageChannel secondMachineChannel,
                                                        @Qualifier("thirdMachineChannel") MessageChannel thirdMachineChannel,
                                                        @Qualifier("mainDiscourseAnomalyChannel") MessageChannel mainAnomalyChannel,
                                                        @Qualifier("anomalyChannel") MessageChannel anomalyChannel){
        Map<String, MessageChannel> router = new HashMap<>();
        router.put("firstMachineChannel", firstMachineChannel);
        router.put("secondMachineChannel", secondMachineChannel);
        router.put("thirdMachineChannel", thirdMachineChannel);
        router.put("anomalyChannel", anomalyChannel);
        router.put("mainDiscourseAnomalyChannel", mainAnomalyChannel);
        return router;
    }
}
