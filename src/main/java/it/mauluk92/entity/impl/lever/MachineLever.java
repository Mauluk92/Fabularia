package it.mauluk92.entity.impl.lever;

import it.mauluk92.entity.EntityOfFabularia;


public class MachineLever extends EntityOfFabularia {
    private boolean status = false;
    @Override
    public void reveal() {
        super.reveal();
        status = !status;
    }

    @Override
    public String toString() {
        return status ? "Push the lever" : "Pull the lever";
    }
}
