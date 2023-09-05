package it.mauluk92.entity.impl.wheel.impl;

import it.mauluk92.entity.impl.wheel.Wheel;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Header;

import java.util.Objects;

public class SecondWheel extends Wheel {


    @Router(inputChannel = "secondWheelChannel")
    public MessageChannel route(@Header String target){
        return getFabricOfTheWheel().get(target);
    }
    @ServiceActivator(inputChannel = "secondWheelLock")
    public void unlock(Message<Boolean> key){
        if(key.getPayload()){
            System.out.println("You hear a mechanical noise from a distant Wheel");
            this.getParent().pushEntity(this);
        }
    }
}
