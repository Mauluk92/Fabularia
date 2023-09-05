package it.mauluk92.config.channel.first;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class FirstWheelChannelConfig {

    @Bean
    @Qualifier("firstWheelChannel")
    public MessageChannel firstWheelChannel(){
        return new DirectChannel();
    }

    @Bean
    @Qualifier("mainDiscourseAnomalyChannel")
    public MessageChannel mainDiscourseAnomalyChannel() {
        return new DirectChannel();
    }

    @Bean
    @Qualifier("soulChannel")
    public MessageChannel soulChannel(){return new DirectChannel();}

    @Bean
    @Qualifier("reverseSoulChannel")
    public MessageChannel reverseSoulChannel(){return new DirectChannel();}

    @Bean
    @Qualifier("firstMachineChannel")
    public MessageChannel firstMachineChannel(){
        return new DirectChannel();
    }

    @Bean
    @Qualifier("secondMachineChannel")
    public MessageChannel secondMachineChannel(){
        return new DirectChannel();
    }

    @Bean
    @Qualifier("thirdMachineChannel")
    public MessageChannel thirdMachineChannel(){
        return new DirectChannel();
    }


    @Bean
    @Qualifier("anomalyChannel")
    public MessageChannel anomalyChannel(){return new DirectChannel();}
}
