package it.mauluk92.command.remote.impl;

import it.mauluk92.command.local.Command;
import it.mauluk92.command.remote.RemoteCommand;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.gateway.LifeGateway;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
@Getter
@Setter
public class ManipulateRemoteEntity<T extends EntityOfFabularia> implements RemoteCommand<T> {

    @Autowired
    private LifeGateway lifeGateway;
    private Command<T> payload;
    private String secondaryChannel;
    private String targetChannel;

    @Override
    public void execute() {
        Message<Command<T>> message = MessageBuilder
                .withPayload(payload)
                .setHeader("secondaryChannel", secondaryChannel)
                .setHeader("target", targetChannel)
                .build();
        lifeGateway.send(message);
    }

}
