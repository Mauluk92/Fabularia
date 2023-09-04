package it.mauluk92.command.impl;

import it.mauluk92.command.Command;
import it.mauluk92.gateway.LifeGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
@RequiredArgsConstructor
public class MachineLeverCommand implements Command {

    @Override
    public void execute(LifeGateway lifeGateway, String target) {
        Message<MachineLeverCommand> message = MessageBuilder
                .withPayload(this)
                .setHeader("secondaryChannel", "firstWheelChannel")
                .setHeader("target", target)
                .build();
        lifeGateway.send(message);
    }
}
