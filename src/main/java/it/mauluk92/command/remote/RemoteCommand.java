package it.mauluk92.command.remote;


import it.mauluk92.entity.EntityOfFabularia;

public interface RemoteCommand<T extends EntityOfFabularia> {

    void execute();
}
