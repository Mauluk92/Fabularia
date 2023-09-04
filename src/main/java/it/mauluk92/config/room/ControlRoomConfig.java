package it.mauluk92.config.room;

import it.mauluk92.config.machinery.FirstMachineryConfig;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.room.ControlRoom;
import it.mauluk92.state.impl.LifeState;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;

@Configuration
@Import(FirstMachineryConfig.class)
public class ControlRoomConfig {


    @Bean
    @Qualifier("firstControlRoom")
    public EntityOfFabularia firstControlRoom(@Qualifier("firstMachine") EntityOfFabularia firstMachine,
                                              @Qualifier("secondMachine")EntityOfFabularia secondMachine,
                                              @Qualifier("thirdMachine") EntityOfFabularia thirdMachine,
                                              @Qualifier("firstMachineLever") EntityOfFabularia firstMachineLever,
                                              @Qualifier("secondMachineLever") EntityOfFabularia secondMachineLever){

        EntityOfFabularia controlRoom = new ControlRoom();
        controlRoom.setDescription("Control room of the first wheel");
        LifeState state = new LifeState();
        state.setState(true);
        controlRoom.setLock(state);
        controlRoom.setChildren(List.of(firstMachine, secondMachine, thirdMachine, firstMachineLever, secondMachineLever));
        firstMachine.setParent(controlRoom);
        secondMachine.setParent(controlRoom);
        thirdMachine.setParent(controlRoom);
        firstMachineLever.setParent(controlRoom);
        secondMachineLever.setParent(controlRoom);
        return controlRoom;
    }

}
