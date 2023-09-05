package it.mauluk92.entity.impl.discourse.impl;

import it.mauluk92.command.local.Command;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.discourse.Discourse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.annotation.ServiceActivator;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class MainDiscourseAnomaly extends Discourse {


    @ServiceActivator(inputChannel = "mainDiscourseAnomalyChannel")
    public void changeState(Command<EntityOfFabularia> command){
        command.execute(this);
        if(getChildren().isEmpty()){
            System.out.println("The anomaly disappears in a puff of smoke and return to its prison");
        }
    }
}
