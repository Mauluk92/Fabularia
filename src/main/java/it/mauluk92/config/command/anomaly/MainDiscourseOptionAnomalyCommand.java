package it.mauluk92.config.command.anomaly;

import it.mauluk92.clockmaker.ClockMaker;
import it.mauluk92.command.local.Command;
import it.mauluk92.command.local.impl.AddEntityCommand;
import it.mauluk92.command.local.impl.AlterEntityCommand;
import it.mauluk92.command.local.impl.NavigateEntityCommand;
import it.mauluk92.command.local.impl.RemoveEntityCommand;
import it.mauluk92.command.remote.impl.ManipulateRemoteEntity;
import it.mauluk92.config.clockmaker.ClockmakerConfig;
import it.mauluk92.config.discourse.FirstAnomalyActionsConfig;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.discourse.Discourse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Import({FirstAnomalyActionsConfig.class, ClockmakerConfig.class})
public class MainDiscourseOptionAnomalyCommand {


    @Bean
    @Qualifier("addSecondOptionCommand")
    public Command<EntityOfFabularia> addSecondOptionCommand(@Qualifier("secondOptionAnomaly")EntityOfFabularia secondOption
    ){
        return new AddEntityCommand(secondOption);
    }

    @Bean
    @Qualifier("removeFirstOptionCommand")
    public Command<EntityOfFabularia> removeFirstOptionCommand(@Qualifier("firstOptionAnomaly") Discourse firstOption){
        return new RemoveEntityCommand(firstOption);
    }

    @Bean
    @Qualifier("removeSecondOptionCommand")
    public Command<EntityOfFabularia> removeSecondOptionCommand(@Qualifier("secondOptionAnomaly") Discourse secondOption){
        return new RemoveEntityCommand(secondOption);
    }


    @Bean
    @Scope("prototype")
    @Qualifier("navigateCommand")
    public Command<EntityOfFabularia> navigateCommand(ClockMaker clockMaker){
        return new NavigateEntityCommand(clockMaker);
    }

    @Bean
    @Qualifier("mainAnomalyOptionRemoveCommand")
    public Command<EntityOfFabularia> mainAnomalyOptionRemoveCommand(@Qualifier("mainAnomalyOption") EntityOfFabularia entity){
        return new RemoveEntityCommand(entity);
    }

    @Bean
    @Qualifier("mainAnomalyOptionAlterCommand")
    public Command<EntityOfFabularia> mainAnomalyOptionAlterCommand(@Qualifier("mainAnomalyOption")  EntityOfFabularia entity){
        return new AlterEntityCommand("The contraption now looks dim and void of life");
    }

    @Bean
    @Qualifier("addSecondOptionRemoteCommand")
    public ManipulateRemoteEntity<EntityOfFabularia> addSecondOptionRemoteCommand(@Qualifier("addSecondOptionCommand") Command<EntityOfFabularia> command){
        ManipulateRemoteEntity<EntityOfFabularia> remoteCommand =  new ManipulateRemoteEntity<>();
        remoteCommand.setPayload(command);
        remoteCommand.setSecondaryChannel("firstWheelChannel");
        remoteCommand.setTargetChannel("mainDiscourseAnomalyChannel");

        return remoteCommand;
    }

    @Bean
    @Qualifier("removeFirstOptionRemoteCommand")
    public ManipulateRemoteEntity<EntityOfFabularia> removeFirstOptionRemoteCommand(@Qualifier("removeFirstOptionCommand") Command<EntityOfFabularia> command){
        ManipulateRemoteEntity<EntityOfFabularia> remoteCommand = new ManipulateRemoteEntity<>();
        remoteCommand.setPayload(command);
        remoteCommand.setSecondaryChannel("firstWheelChannel");
        remoteCommand.setTargetChannel("mainDiscourseAnomalyChannel");
        return remoteCommand;
    }

    @Bean
    @Qualifier("removeSecondOptionRemoteCommand")
    public ManipulateRemoteEntity<EntityOfFabularia> removeSecondOptionRemoteCommand(@Qualifier("removeSecondOptionCommand") Command<EntityOfFabularia> command){
        ManipulateRemoteEntity<EntityOfFabularia> remoteCommand = new ManipulateRemoteEntity<>();
        remoteCommand.setPayload(command);
        remoteCommand.setSecondaryChannel("firstWheelChannel");
        remoteCommand.setTargetChannel("mainDiscourseAnomalyChannel");
        return remoteCommand;
    }

    @Bean
    @Qualifier("mainAnomalyRemoveRemoteCommand")
    public ManipulateRemoteEntity<EntityOfFabularia> mainAnomalyRemoveRemoteCommand(@Qualifier("mainAnomalyOptionRemoveCommand")Command<EntityOfFabularia> command){
        ManipulateRemoteEntity<EntityOfFabularia> remoteCommand = new ManipulateRemoteEntity<>();
        remoteCommand.setPayload(command);
        remoteCommand.setSecondaryChannel("firstWheelChannel");
        remoteCommand.setTargetChannel("anomalyChannel");
        return remoteCommand;

    }

    @Bean
    @Qualifier("mainAnomalyAlterRemoteCommand")
    public ManipulateRemoteEntity<EntityOfFabularia> mainAnomalyAlterRemoteCommand(@Qualifier("mainAnomalyOptionAlterCommand")Command<EntityOfFabularia> command){
        ManipulateRemoteEntity<EntityOfFabularia> remoteCommand = new ManipulateRemoteEntity<>();
        remoteCommand.setPayload(command);
        remoteCommand.setSecondaryChannel("firstWheelChannel");
        remoteCommand.setTargetChannel("anomalyChannel");
        return remoteCommand;
    }

    @Bean
    @Qualifier("mainAnomalyNavigateRemoteCommand")
    public ManipulateRemoteEntity<EntityOfFabularia> mainAnomalyNavigateRemoteCommand(@Qualifier("navigateCommand") Command<EntityOfFabularia> navigateCommand){
        ManipulateRemoteEntity<EntityOfFabularia> remoteCommand = new ManipulateRemoteEntity<>();
        remoteCommand.setPayload(navigateCommand);
        remoteCommand.setSecondaryChannel("firstWheelChannel");
        remoteCommand.setTargetChannel("anomalyChannel");
        return remoteCommand;
    }

    @Bean
    @Qualifier("anomalyFirstOptionCommandList")
    public List<ManipulateRemoteEntity<? extends EntityOfFabularia>> anomalyFirstOptionCommandList(@Qualifier("addSecondOptionRemoteCommand") ManipulateRemoteEntity<EntityOfFabularia> firstCommand,
                                                                                                   @Qualifier("removeFirstOptionRemoteCommand") ManipulateRemoteEntity<EntityOfFabularia> secondCommand){
        List<ManipulateRemoteEntity<? extends EntityOfFabularia>> commandList = new ArrayList<>();
        commandList.add(firstCommand);
        commandList.add(secondCommand);
        return commandList;
    }

    @Bean
    @Qualifier("anomalySecondOptionCommandList")
    public List<ManipulateRemoteEntity<? extends EntityOfFabularia>> anomalySecondOptionCommandList(@Qualifier("mainAnomalyRemoveRemoteCommand") ManipulateRemoteEntity<EntityOfFabularia> firstCommand,
                                                                                                    @Qualifier("mainAnomalyAlterRemoteCommand") ManipulateRemoteEntity<EntityOfFabularia> secondCommand,
                                                                                                    @Qualifier("mainAnomalyNavigateRemoteCommand") ManipulateRemoteEntity<EntityOfFabularia> navigateCommand){
        List<ManipulateRemoteEntity<? extends EntityOfFabularia>> commandList = new ArrayList<>();
        commandList.add(firstCommand);
        commandList.add(secondCommand);
        commandList.add(navigateCommand);
        return commandList;
    }
}
