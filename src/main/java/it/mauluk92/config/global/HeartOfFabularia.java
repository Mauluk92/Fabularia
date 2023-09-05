package it.mauluk92.config.global;

import it.mauluk92.config.clockmaker.ClockmakerConfig;
import it.mauluk92.config.wheel.FirstWheelConfig;
import it.mauluk92.config.wheel.MasterWheelConfig;
import it.mauluk92.config.wheel.SecondWheelConfig;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.net.MasterWheel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;

@Configuration
@Import({FirstWheelConfig.class, SecondWheelConfig.class, MasterWheelConfig.class})
public class HeartOfFabularia {


    @Bean
    @Qualifier("fabularia")
    public MasterWheel fabularia(@Qualifier("firstWheelChildren") List<EntityOfFabularia> firstWheelChildren,
                                   @Qualifier("secondWheelChildren") List<EntityOfFabularia> secondWheelChildren,
                                   @Qualifier("masterWheel")MasterWheel masterWheel,
                                   @Qualifier("firstWheel") EntityOfFabularia firstWheel,
                                   @Qualifier("secondWheel") EntityOfFabularia secondWheel){
        firstWheelChildren.forEach(firstWheel::pushEntity);
        secondWheelChildren.forEach(secondWheel::pushEntity);
        masterWheel.pushEntity(firstWheel);
        masterWheel.setParent(masterWheel);
        secondWheel.setParent(masterWheel);
        return masterWheel;
    }

}
