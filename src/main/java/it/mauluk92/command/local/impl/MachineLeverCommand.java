package it.mauluk92.command.local.impl;

import it.mauluk92.command.local.Command;
import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.machinery.AncientMachinery;

public class MachineLeverCommand implements Command<AncientMachinery> {

    @Override
    public void execute(AncientMachinery subject) {
        subject.switchState();
    }
}
