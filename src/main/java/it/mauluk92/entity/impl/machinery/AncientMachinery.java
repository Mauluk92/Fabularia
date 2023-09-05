package it.mauluk92.entity.impl.machinery;

import it.mauluk92.command.local.Command;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.state.State;
import lombok.Getter;
import lombok.Setter;
import org.springframework.messaging.Message;

@Getter
@Setter
public abstract class AncientMachinery extends EntityOfFabularia {

    private State state;
    private String name;
    public void switchState() {
        String previousState = state.toString();
        state.activate();
        System.out.println("The " + name + " alters its state from " + previousState + " to " + state);
    }
    @Override
    public String toString() {
        return getDescription() + "\n The machine currently is in state: " + state;
    }
}
