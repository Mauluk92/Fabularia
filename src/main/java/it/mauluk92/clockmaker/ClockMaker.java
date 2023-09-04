package it.mauluk92.clockmaker;

import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.state.State;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.annotation.ServiceActivator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ClockMaker extends EntityOfFabularia {

    private final Scanner mind;
    private Boolean sigillOfExistence = true;

    public void weave(EntityOfFabularia entity) {
        List<EntityOfFabularia> options = new ArrayList<>(entity.getChildren());
        options.add(entity.getParent());
        List<EntityOfFabularia> availableOptions = options.stream().filter(e -> e.getLock().reveal()).collect(Collectors.toList());
        int fate = choose(availableOptions);
        EntityOfFabularia entityChosen = availableOptions.get(fate);
        entityChosen.reveal();
        if(sigillOfExistence) {
            weave(entityChosen);
        }
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
