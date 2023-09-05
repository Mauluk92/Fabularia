package it.mauluk92.entity.impl.discourse;

import it.mauluk92.command.local.Command;
import it.mauluk92.command.remote.impl.ManipulateRemoteEntity;
import it.mauluk92.entity.EntityOfFabularia;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
public class Discourse extends EntityOfFabularia {

    private String content;
    @Override
    public void reveal() {
        System.out.println(content);
        super.reveal();
        if(getChildren().isEmpty()){
            setContent("The anomaly disappears and returns to its ethereal prison");
            System.out.println(content);
        }
    }
}
