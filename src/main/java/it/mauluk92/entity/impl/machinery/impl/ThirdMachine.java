package it.mauluk92.entity.impl.machinery.impl;

import it.mauluk92.entity.impl.machinery.AncientMachinery;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class ThirdMachine extends AncientMachinery {


    @Override
    @ServiceActivator(inputChannel = "thirdMachineChannel", outputChannel = "masterWheelChannel")
    public Message<Boolean> sendMessage() {
        return MessageBuilder.withPayload(getLock().reveal())
                .setHeader("secondaryChannel", "secondWheelChannel")
                .setHeader("target", "secondWheelLock").build();
    }

    @Override
    public String toString() {
        return "The third machine is in state: " + (getLock().reveal() ? "Life" : "Death");
    }
}
