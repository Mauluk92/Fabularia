package it.mauluk92.entity.impl.wheel;

import it.mauluk92.entity.EntityOfFabularia;
import lombok.Getter;
import lombok.Setter;
import org.springframework.messaging.MessageChannel;

import java.util.Map;

@Getter
@Setter
public abstract class Wheel extends EntityOfFabularia {

    private Map<String, MessageChannel> fabricOfTheWheel;

}
