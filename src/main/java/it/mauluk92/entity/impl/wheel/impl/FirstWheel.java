package it.mauluk92.entity.impl.wheel.impl;

import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.wheel.Wheel;
import org.springframework.integration.annotation.Router;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Header;


public class FirstWheel extends Wheel {

    @Router(inputChannel = "firstWheelChannel")
    public MessageChannel route(@Header String target){
        return getFabricOfTheWheel().get(target);
    }
    @Override
    public void reveal() {
        System.out.println("You enter the first wheel in the astral plane of Fabularia");
    }
}
