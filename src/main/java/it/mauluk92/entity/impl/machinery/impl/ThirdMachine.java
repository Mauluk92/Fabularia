package it.mauluk92.entity.impl.machinery.impl;

import it.mauluk92.command.local.Command;
import it.mauluk92.entity.impl.machinery.AncientMachinery;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class ThirdMachine extends AncientMachinery {


    @ServiceActivator(inputChannel = "thirdMachineChannel", outputChannel = "masterWheelChannel")
    public Message<Boolean> receiveAndSend(Message<Boolean> command) {
        return MessageBuilder.withPayload(getState().reveal())
                .setHeader("secondaryChannel", "secondWheelChannel")
                .setHeader("target", "secondWheelLock").build();
    }

    @Override
    public String toString() {
        return "The third machine is in state: " + (getState().reveal() ? "Life" : "Death");
    }
}
