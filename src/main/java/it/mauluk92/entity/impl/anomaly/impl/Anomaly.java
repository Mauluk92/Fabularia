package it.mauluk92.entity.impl.anomaly.impl;

import it.mauluk92.entity.EntityOfFabularia;
import it.mauluk92.entity.impl.anomaly.ConsciousEntity;
import it.mauluk92.state.State;

public class Anomaly extends ConsciousEntity {

    @Override
    public void reveal() {
        if(getChildren().stream().map(EntityOfFabularia::getLock).noneMatch(State::reveal)){
            System.out.println("The anomaly doesn't have anything to say anymore");
            getLock().activate();
        }else {
            System.out.println("As you channel the energy, an astral anomaly appears, in the form of an ethereal humanoid");
        }
    }
}
