package it.mauluk92.entity.impl.machinery.impl;

import it.mauluk92.command.local.Command;
import it.mauluk92.entity.impl.machinery.AncientMachinery;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class FirstMachine extends AncientMachinery {

    @ServiceActivator(inputChannel = "firstMachineChannel", outputChannel = "masterWheelChannel")
    public Message<Boolean> receiveAndSend(Command<AncientMachinery> command){
        command.execute(this);
        return MessageBuilder.withPayload(getState().reveal())
                .setHeader("secondaryChannel", "firstWheelChannel")
                .setHeader("target", "thirdMachineChannel").build();
    }
}
