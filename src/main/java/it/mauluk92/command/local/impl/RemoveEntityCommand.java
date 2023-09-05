package it.mauluk92.command.local.impl;


import it.mauluk92.command.local.Command;
import it.mauluk92.entity.EntityOfFabularia;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RemoveEntityCommand implements Command<EntityOfFabularia> {

    private final EntityOfFabularia entity;

    @Override
    public void execute(EntityOfFabularia subject) {
        subject.removeEntity(entity);
    }
}
