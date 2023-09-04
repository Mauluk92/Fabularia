package it.mauluk92.entity.impl.machinery;

import it.mauluk92.entity.EntityOfFabularia;
import org.springframework.messaging.Message;
public abstract class AncientMachinery extends EntityOfFabularia {

    public void switchState(String machineName) {
        String previousState = getLock().toString();
        getLock().activate();
        System.out.println("The " + machineName + " alters its state from " + previousState + " to " + getLock());
    }

    public abstract Message<Boolean> sendMessage();

    @Override
    public String toString() {
        return getDescription() + "\n The machine currently is in state: " + getLock();
    }
}
