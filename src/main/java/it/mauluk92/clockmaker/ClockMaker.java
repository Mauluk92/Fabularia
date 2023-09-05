package it.mauluk92.clockmaker;

import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.state.State;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.integration.annotation.ServiceActivator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ClockMaker extends EntityOfFabularia {

    private final Scanner mind;
    private EntityOfFabularia currentPosition;
    private Boolean sigillOfExistence = true;

    public void weave() {
        currentPosition.reveal();
        if(sigillOfExistence && !currentPosition.getChildren().isEmpty()) {
            List<EntityOfFabularia> options = new ArrayList<>(this.currentPosition.getChildren());
            options.add(this.currentPosition.getParent());
            int fate = choose(options);
            currentPosition = options.get(fate);
            weave();
        } else if (sigillOfExistence) {
            currentPosition = currentPosition.getParent();
            weave();
        }
    }

    @ServiceActivator(inputChannel = "reverseSoulChannel")
    public void navigate(EntityOfFabularia entity){
        currentPosition = entity;
    }

    @ServiceActivator(inputChannel = "soulChannel")
    public void breakExistence(){
        sigillOfExistence = false;
    }

    private int choose(List<EntityOfFabularia> options) {
        while (true) {
            options.forEach(o -> System.out.println(options.indexOf(o) + " " + o));
            try {
                int fate = Integer.parseInt(mind.next());
                if (fate < options.size() && fate >= 0) {
                    return fate;
                } else {
                    System.out.println("You are overstepping the possibilities");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Choose a valid alternative");
            }
        }
    }
}
