package it.mauluk92.entity.impl.anomaly.impl;

import it.mauluk92.command.local.Command;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.anomaly.ConsciousEntity;
import it.mauluk92.entity.impl.discourse.Discourse;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

public class Anomaly extends ConsciousEntity {

    @ServiceActivator(inputChannel = "anomalyChannel")
    public void changeState(Message<Command<EntityOfFabularia>> commandMessage){
        commandMessage.getPayload().execute(this);
    }

    @Override
    public void reveal() {
        if(getChildren().isEmpty()){
            System.out.println("You cannot channel energy inside the contraption");
            setDescription("The contraption now looks dim and void of life");
        }else {
            System.out.println("As you channel the energy, an astral anomaly appears, in the form of an ethereal humanoid");
        }
    }
}
