package it.mauluk92.command.local.impl;

import it.mauluk92.clockmaker.ClockMaker;
import it.mauluk92.command.local.Command;
import it.mauluk92.entity.EntityOfFabularia;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NavigateEntityCommand implements Command<EntityOfFabularia> {

    private final ClockMaker clockMaker;

    @Override
    public void execute(EntityOfFabularia subject) {
        clockMaker.navigate(subject);
    }
}
