package it.mauluk92.gateway;

import it.mauluk92.entity.EntityOfFabularia;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@MessagingGateway
public interface LifeGateway {


    @Gateway(requestChannel = "masterWheelChannel")
    void send(Message<?> key);

    @Gateway(requestChannel = "soulChannel")
    void soulLink(@Payload Message<EntityOfFabularia> keyOfExistence);
}
