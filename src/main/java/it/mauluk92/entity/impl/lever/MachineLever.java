package it.mauluk92.entity.impl.lever;

import it.mauluk92.command.Command;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.gateway.LifeGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MachineLever extends EntityOfFabularia {

    private boolean status = false;
    private final Command command;
    private final String target;
    private final LifeGateway lifeGateway;

    @Override
    public void reveal() {
        command.execute(lifeGateway, target);
        status = !status;
    }

    @Override
    public String toString() {
        return status ? "Push the lever" : "Pull the lever";
    }
}
