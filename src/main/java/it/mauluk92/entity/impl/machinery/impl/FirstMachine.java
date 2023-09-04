package it.mauluk92.entity.impl.machinery.impl;

import it.mauluk92.entity.impl.machinery.AncientMachinery;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class FirstMachine extends AncientMachinery {

    @ServiceActivator(inputChannel = "firstMachineChannel", outputChannel = "masterWheelChannel")
    @Override
    public Message<Boolean> sendMessage(){
        switchState("First Machine");
        return MessageBuilder.withPayload(getLock().reveal())
                .setHeader("secondaryChannel", "firstWheelChannel")
                .setHeader("target", "thirdMachineChannel").build();
    }
}
