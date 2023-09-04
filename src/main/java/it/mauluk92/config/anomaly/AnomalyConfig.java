package it.mauluk92.config.anomaly;

import it.mauluk92.config.discourse.FirstAnomalyActionsConfig;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.anomaly.ConsciousEntity;
import it.mauluk92.entity.impl.anomaly.impl.Anomaly;
import it.mauluk92.state.impl.LifeState;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Import(FirstAnomalyActionsConfig.class)
public class AnomalyConfig {

    @Bean
    @Qualifier("anomaly")
    public EntityOfFabularia anomaly(@Qualifier("mainAnomalyOption") EntityOfFabularia entity){
        ConsciousEntity anomaly = new Anomaly();
        String description = "You are looking at a mechanical contraption:\n it glows with a shiny blue aura.\n You could try to channel the energy of your clock inside the machinery...";
        anomaly.setLock(new LifeState());
        List<EntityOfFabularia> childrenActions = new ArrayList<>();
        childrenActions.add(entity);
        anomaly.setChildren(childrenActions);
        entity.setParent(anomaly);
        LifeState lifeState = new LifeState();
        lifeState.setState(true);
        anomaly.setLock(lifeState);
        anomaly.setDescription(description);
        return anomaly;
    }

}
