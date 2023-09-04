package it.mauluk92.config.discourse;

import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.discourse.Discourse;
import it.mauluk92.state.State;
import it.mauluk92.state.impl.LifeState;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;

import java.util.ArrayList;
import java.util.List;

@Configuration
@IntegrationComponentScan(basePackages = {"it.mauluk92"})
public class FirstAnomalyActionsConfig {


    @Bean
    @Qualifier("firstOptionAnomaly")
    public EntityOfFabularia firstOptionAnomaly(@Qualifier("firstAnomalyOptionState") State state,
                                                @Qualifier("secondAnomalyOptionState") State secondState
                                                ){
        String firstDiscourse = "Have you come far away from home, poor soul?\n";
        String secondDiscourse = "This place is left for us as a prison\n";
        String thirdDiscourse = "We, as anomalies, don't have the privilege to live as other people of Fabularia\n";
        String fourthDiscourse = "What do you want to know, poor soul?\n";
        String description = "Talk to the anomaly";
        Discourse discourse = new Discourse(firstDiscourse
                .concat(secondDiscourse)
                .concat(thirdDiscourse)
                .concat(fourthDiscourse),
                List.of(secondState));
        discourse.setChildren(new ArrayList<>());
        discourse.setLock(state);
        discourse.setDescription(description);
        return discourse;
    }

    @Bean
    @Qualifier("secondOptionAnomaly")
    public EntityOfFabularia secondOptionAnomaly(@Qualifier("secondAnomalyOptionState") State state){
        String firstDiscourse = "The chaos dragon, Noise, reside in the farthest Wheel of Fabularia\n";
        String secondDiscourse = "Nobody can reach this wheel, unless of course you want to die\n";
        String thirdDiscourse = "Risk your life at your own peril... now leave me alone\n";
        Discourse discourse = new Discourse(firstDiscourse
                .concat(secondDiscourse)
                .concat(thirdDiscourse),
                new ArrayList<>());
        String description = "Ask about the Chaos Dragon";
        discourse.setChildren(new ArrayList<>());
        discourse.setLock(state);
        discourse.setDescription(description);
        return discourse;
    }

    @Bean
    @Qualifier("mainAnomalyOption")
    public EntityOfFabularia mainAnomalyOption(@Qualifier("mainAnomalyOptionState") State state,
                                               @Qualifier("firstOptionAnomaly") EntityOfFabularia firstOption,
                                               @Qualifier("secondOptionAnomaly") EntityOfFabularia secondOption
                                               ){
        String content = "I will do as you command. But once i've answered your questions, i will return to my prison";
        String description= "Command the anomaly to speak";
        Discourse discourse = new Discourse(content, new ArrayList<>());
        discourse.setLock(state);
        discourse.setDescription(description);
        discourse.setChildren(List.of(firstOption, secondOption));
        firstOption.setParent(discourse);
        secondOption.setParent(discourse);
        return discourse;
    }

    @Bean
    @Qualifier("mainAnomalyOptionState")
    public State mainAnomalyOptionState(){
        LifeState state = new LifeState();
        state.setState(true);
        return state;
    }


    @Bean
    @Qualifier("firstAnomalyOptionState")
    public State firstAnomalyOptionState(){
        LifeState state = new LifeState();
        state.setState(true);
        return state;
    }

    @Bean
    @Qualifier("secondAnomalyOptionState")
    public State secondAnomalyOptionState(){
        LifeState state = new LifeState();
        state.setState(false);
        return state;
    }
}
