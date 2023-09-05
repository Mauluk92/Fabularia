package it.mauluk92.command.local;

import it.mauluk92.entity.EntityOfFabularia;

public interface Command<T extends EntityOfFabularia>{
    void execute(T subject);
}
