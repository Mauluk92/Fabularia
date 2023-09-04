package it.mauluk92.state.impl;

import it.mauluk92.state.State;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class AndState implements State {

    private final List<State> states;


    @Override
    public boolean reveal() {
        return states.stream()
                .map(State::reveal)
                .reduce(Boolean::logicalAnd)
                .orElse(false);
    }

    @Override
    public boolean activate() {
        return states.stream()
                .map(State::activate)
                .reduce(Boolean::logicalAnd)
                .orElse(false);
    }
}
