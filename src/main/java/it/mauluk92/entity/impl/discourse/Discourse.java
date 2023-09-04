package it.mauluk92.entity.impl.discourse;

import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.state.State;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Discourse extends EntityOfFabularia {

    private final String content;
    private final List<State> optionsUnlocked;

    @Override
    public void reveal() {
        if(getChildren().stream().noneMatch(e -> e.getLock().reveal())){
            getLock().activate();
            optionsUnlocked.forEach(State::activate);
        }
        System.out.println(content);
    }
}
