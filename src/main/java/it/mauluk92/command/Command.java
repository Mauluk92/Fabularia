package it.mauluk92.command;


import it.mauluk92.gateway.LifeGateway;

public interface Command {

    void execute(LifeGateway lifeGateway, String target);
}
