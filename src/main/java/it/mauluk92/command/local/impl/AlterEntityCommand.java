package it.mauluk92.command.local.impl;

import it.mauluk92.command.local.Command;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.discourse.Discourse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AlterEntityCommand implements Command<EntityOfFabularia> {

    private final String newDescription;

    @Override
    public void execute(EntityOfFabularia subject) {
        subject.setDescription(newDescription);
    }
}
