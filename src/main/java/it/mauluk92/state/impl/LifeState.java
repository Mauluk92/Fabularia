package it.mauluk92.state.impl;

import it.mauluk92.state.State;
import lombok.Setter;

@Setter
public class LifeState implements State {

    private boolean state;

    @Override
    public boolean reveal() {
        return state;
    }

    @Override
    public boolean activate() {
        boolean output = state;
        state = !state;
        return output;
    }

    @Override
    public String toString() {
        return state ? "Life" : "Death";
    }
}
