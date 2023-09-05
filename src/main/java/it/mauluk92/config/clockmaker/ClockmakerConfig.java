package it.mauluk92.config.clockmaker;

import it.mauluk92.clockmaker.ClockMaker;
import it.mauluk92.gateway.LifeGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ClockmakerConfig {


    @Bean
    public ClockMaker clockMaker(Scanner mind)
    {
        return new ClockMaker(mind);
    }

    @Bean
    public Scanner mind(){
        return new Scanner(System.in);
    }
}
