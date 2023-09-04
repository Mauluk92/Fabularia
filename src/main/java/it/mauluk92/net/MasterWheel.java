package it.mauluk92.net;

import it.mauluk92.entity.EntityOfFabularia;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.annotation.Router;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Header;

import java.util.Map;

@RequiredArgsConstructor
public class MasterWheel extends EntityOfFabularia{


    private final Map<String, MessageChannel> fabricOfFabularia;

    @Router(inputChannel = "masterWheelChannel")
    public MessageChannel route(@Header("secondaryChannel") String secondaryChannel){
        return fabricOfFabularia.get(secondaryChannel);
    }
}
