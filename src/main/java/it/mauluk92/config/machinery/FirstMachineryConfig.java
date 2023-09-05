package it.mauluk92.config.machinery;

import it.mauluk92.command.remote.impl.ManipulateRemoteEntity;
import it.mauluk92.config.command.machine.MachineNodeCommandConfig;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.lever.MachineLever;
import it.mauluk92.entity.impl.machinery.AncientMachinery;
import it.mauluk92.entity.impl.machinery.impl.FirstMachine;
import it.mauluk92.entity.impl.machinery.impl.SecondMachine;
import it.mauluk92.entity.impl.machinery.impl.ThirdMachine;
import it.mauluk92.state.State;
import it.mauluk92.state.impl.AndState;
import it.mauluk92.state.impl.LifeState;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Import(MachineNodeCommandConfig.class)
public class FirstMachineryConfig {



    @Bean
    @Qualifier("firstMachine")
    public EntityOfFabularia firstMachine(@Qualifier("firstMachineState") State firstMachineState){
        AncientMachinery machine = new FirstMachine();
        machine.setName("First Machine");
        String description = "The first machine of the control room";
        machine.setChildren(new ArrayList<>());
        machine.setState(firstMachineState);
        machine.setDescription(description);
        return machine;
    }

    @Bean
    @Qualifier("secondMachine")
    public EntityOfFabularia secondMachine(@Qualifier("secondMachineState") State secondMachineState){
        AncientMachinery machine = new SecondMachine();
        machine.setName("Second Machine");
        String description = "The second machine of the control room";
        machine.setDescription(description);
        machine.setChildren(new ArrayList<>());
        machine.setState(secondMachineState);
        return machine;
    }

    @Bean
    @Qualifier("thirdMachine")
    public EntityOfFabularia thirdMachine(@Qualifier("thirdMachineState") State thirdMachineState){
        AncientMachinery machine = new ThirdMachine();
        machine.setName("Third Machine");
        String description = "The third machine of the control room: connected to the previous two ones";
        machine.setState(thirdMachineState);
        machine.setChildren(new ArrayList<>());
        machine.setDescription(description);
        return machine;
    }


    @Bean
    @Qualifier("firstMachineState")
    public State firstMachineState(){
        LifeState state = new LifeState();
        state.setState(false);
        return state;
    }

    @Bean
    @Qualifier("secondMachineState")
    public State secondMachineState(){
        LifeState state = new LifeState();
        state.setState(false);
        return state;
    }

    @Bean
    @Qualifier("thirdMachineState")
    public State thirdMachineState(@Qualifier("firstMachineState") State firstMachineState,
                                   @Qualifier("secondMachineState") State secondMachineState){
        return new AndState(List.of(firstMachineState, secondMachineState));
    }

    @Bean
    @Qualifier("firstMachineLever")
    public EntityOfFabularia firstMachineLever(@Qualifier("firstMachineRemoteCommand") ManipulateRemoteEntity<AncientMachinery> remoteCommand){
        EntityOfFabularia lever = new MachineLever();
        lever.setCommandList(List.of(remoteCommand));
        lever.setDescription("First Lever, connected to the first Machine");
        return lever;
    }

    @Bean
    @Qualifier("secondMachineLever")
    public EntityOfFabularia secondMachineLever(@Qualifier("secondMachineRemoteCommand") ManipulateRemoteEntity<AncientMachinery> remoteCommand){
        EntityOfFabularia lever = new MachineLever();
        lever.setCommandList(List.of(remoteCommand));
        lever.setDescription("Second Lever, connected to the second Machine");
        return lever;
    }
}
