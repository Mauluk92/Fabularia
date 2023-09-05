package it.mauluk92.config.anomaly;

import it.mauluk92.command.remote.impl.ManipulateRemoteEntity;
import it.mauluk92.config.command.anomaly.MainDiscourseOptionAnomalyCommand;
import it.mauluk92.config.discourse.FirstAnomalyActionsConfig;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.anomaly.ConsciousEntity;
import it.mauluk92.entity.impl.anomaly.impl.Anomaly;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;

@Configuration
@Import({FirstAnomalyActionsConfig.class, MainDiscourseOptionAnomalyCommand.class})
public class AnomalyConfig {

    @Bean
    @Qualifier("anomaly")
    public EntityOfFabularia anomaly(@Qualifier("mainAnomalyOption") EntityOfFabularia entity,
                                     @Qualifier("firstOptionAnomaly") EntityOfFabularia firstOption,
                                     @Qualifier("secondOptionAnomaly") EntityOfFabularia secondOption,
                                     @Qualifier("anomalyFirstOptionCommandList")List<ManipulateRemoteEntity<? extends EntityOfFabularia>> firstList,
                                     @Qualifier("anomalySecondOptionCommandList")List<ManipulateRemoteEntity<? extends EntityOfFabularia>> secondList){
        ConsciousEntity anomaly = new Anomaly();
        firstOption.setCommandList(firstList);
        secondOption.setCommandList(secondList);
        entity.pushEntity(firstOption);
        anomaly.pushEntity(entity);
        String description = "You are looking at a mechanical contraption:\n it glows with a shiny blue aura.\n You could try to channel the energy of your clock inside the machinery...";
        anomaly.setDescription(description);
        return anomaly;
    }

}
