package it.mauluk92.config.command.machine;

import it.mauluk92.command.local.Command;
import it.mauluk92.command.local.impl.MachineLeverCommand;
import it.mauluk92.command.remote.impl.ManipulateRemoteEntity;
import it.mauluk92.entity.impl.lever.MachineLever;
import it.mauluk92.entity.impl.machinery.AncientMachinery;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MachineNodeCommandConfig {

    @Bean
    @Scope("prototype")
    @Qualifier("firstMachineLever")
    public Command<AncientMachinery> firstMachineLeverCommand(){
        return new MachineLeverCommand();
    }


    @Bean
    @Qualifier("firstMachineRemoteCommand")
    public ManipulateRemoteEntity<AncientMachinery> firstMachineRemoteCommand(@Qualifier("firstMachineLever") Command<AncientMachinery> machineLeverCommand){
        ManipulateRemoteEntity<AncientMachinery> remoteCommand = new ManipulateRemoteEntity<>();
        remoteCommand.setPayload(machineLeverCommand);
        remoteCommand.setSecondaryChannel("firstWheelChannel");
        remoteCommand.setTargetChannel("firstMachineChannel");
        return remoteCommand;
    }

    @Bean
    @Qualifier("secondMachineRemoteCommand")
    public ManipulateRemoteEntity<AncientMachinery> secondMachineRemoteCommand(@Qualifier("firstMachineLever") Command<AncientMachinery> machineLeverCommand) {
        ManipulateRemoteEntity<AncientMachinery> remoteCommand = new ManipulateRemoteEntity<>();
        remoteCommand.setPayload(machineLeverCommand);
        remoteCommand.setSecondaryChannel("firstWheelChannel");
        remoteCommand.setTargetChannel("secondMachineChannel");
        return remoteCommand;
    }

}
