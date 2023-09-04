package it.mauluk92.config.command;

import it.mauluk92.command.Command;
import it.mauluk92.command.impl.MachineLeverCommand;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.integration.annotation.IntegrationComponentScan;

@Configuration
@IntegrationComponentScan(basePackages = {"it.mauluk92"})
public class FirstNodeCommandConfig {


    @Bean
    @Qualifier("firstMachineLeverCommand")
    @Scope("prototype")
    public Command firstMachineLeverCommand(){
        return new MachineLeverCommand();
    }

}
