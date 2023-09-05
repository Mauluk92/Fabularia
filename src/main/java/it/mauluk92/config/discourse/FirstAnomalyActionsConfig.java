package it.mauluk92.config.discourse;

import it.mauluk92.command.local.Command;
import it.mauluk92.command.local.impl.RemoveEntityCommand;
import it.mauluk92.command.remote.impl.ManipulateRemoteEntity;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.discourse.Discourse;
import it.mauluk92.entity.impl.discourse.impl.FirstOptionAnomaly;
import it.mauluk92.entity.impl.discourse.impl.MainDiscourseAnomaly;
import it.mauluk92.entity.impl.discourse.impl.SecondOptionAnomaly;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@IntegrationComponentScan(basePackages = {"it.mauluk92"})
@EnableIntegration
public class FirstAnomalyActionsConfig {


    @Bean
    @Qualifier("firstOptionAnomaly")
    public Discourse firstOptionAnomaly(){
        String firstDiscourse = "Have you come far away from home, poor soul?\n";
        String secondDiscourse = "This place is left for us as a prison\n";
        String thirdDiscourse = "We, as anomalies, don't have the privilege to live as other people of Fabularia\n";
        String fourthDiscourse = "What do you want to know, poor soul?\n";
        String description = "Talk to the anomaly";
        Discourse discourse = new FirstOptionAnomaly();
        discourse.setContent(firstDiscourse.concat(secondDiscourse).concat(thirdDiscourse).concat(fourthDiscourse));
        discourse.setDescription(description);
        return discourse;
    }

    @Bean
    @Qualifier("secondOptionAnomaly")
    public Discourse secondOptionAnomaly(){
        String firstDiscourse = "The chaos dragon, Noise, reside in the farthest Wheel of Fabularia\n";
        String secondDiscourse = "Nobody can reach this wheel, unless of course you want to die\n";
        String thirdDiscourse = "Risk your life at your own peril... now leave me alone\n";
        Discourse discourse = new SecondOptionAnomaly();
        discourse.setContent(firstDiscourse.concat(secondDiscourse).concat(thirdDiscourse));
        String description = "Ask about the Chaos Dragon";
        discourse.setDescription(description);

        return discourse;
    }

    @Bean
    @Qualifier("mainAnomalyOption")
    public EntityOfFabularia mainAnomalyOption(){
        String content = "I will do as you command. But once i've answered your questions, i will return to my prison";
        String description= "Command the anomaly to speak";
        MainDiscourseAnomaly discourse = new MainDiscourseAnomaly();
        discourse.setContent(content);
        discourse.setDescription(description);
        return discourse;
    }
}
