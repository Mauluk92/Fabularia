package it.mauluk92.config.machinery;

import it.mauluk92.command.Command;
import it.mauluk92.config.command.FirstNodeCommandConfig;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.lever.MachineLever;
import it.mauluk92.entity.impl.machinery.impl.FirstMachine;
import it.mauluk92.entity.impl.machinery.impl.SecondMachine;
import it.mauluk92.entity.impl.machinery.impl.ThirdMachine;
import it.mauluk92.gateway.LifeGateway;
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
@Import(FirstNodeCommandConfig.class)
public class FirstMachineryConfig {



    @Bean
    @Qualifier("firstMachine")
    public EntityOfFabularia firstMachine(@Qualifier("firstMachineState") State firstMachineState){
        EntityOfFabularia machine = new FirstMachine();
        String description = "The first machine of the control room";
        machine.setChildren(new ArrayList<>());
        machine.setLock(firstMachineState);
        machine.setDescription(description);
        return machine;
    }

    @Bean
    @Qualifier("secondMachine")
    public EntityOfFabularia secondMachine(@Qualifier("secondMachineState") State secondMachineState){
        EntityOfFabularia machine = new SecondMachine();
        String description = "The second machine of the control room";
        machine.setDescription(description);
        machine.setChildren(new ArrayList<>());
        machine.setLock(secondMachineState);
        return machine;
    }

    @Bean
    @Qualifier("thirdMachine")
    public EntityOfFabularia thirdMachine(@Qualifier("thirdMachineState") State thirdMachineState){
        EntityOfFabularia machine = new ThirdMachine();
        String description = "The third machine of the control room: connected to the previous two ones";
        machine.setLock(thirdMachineState);
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
    public EntityOfFabularia firstMachineLever(LifeGateway lifeGateway,
                                               @Qualifier("firstMachineLeverCommand")Command command){
        EntityOfFabularia lever = new MachineLever(command, "firstMachineChannel", lifeGateway);
        lever.setDescription("First Lever, connected to the first Machine");
        LifeState lifeState = new LifeState();
        lifeState.setState(true);
        lever.setChildren(new ArrayList<>());
        lever.setLock(lifeState);
        return lever;
    }

    @Bean
    @Qualifier("secondMachineLever")
    public EntityOfFabularia secondMachineLever(LifeGateway lifeGateway,
                                                @Qualifier("firstMachineLeverCommand")Command command){
        EntityOfFabularia lever = new MachineLever(command, "secondMachineChannel", lifeGateway);
        lever.setDescription("Second Lever, connected to the second Machine");
        LifeState lifeState = new LifeState();
        lifeState.setState(true);
        lever.setChildren(new ArrayList<>());
        lever.setLock(lifeState);
        return lever;
    }
}
