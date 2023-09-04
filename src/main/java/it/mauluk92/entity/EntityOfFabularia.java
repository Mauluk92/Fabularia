package it.mauluk92.entity;


import it.mauluk92.gateway.LifeGateway;
import it.mauluk92.state.State;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public abstract class EntityOfFabularia {

    private EntityOfFabularia parent;
    private List<EntityOfFabularia> children;
    private String description;
    private State lock;
    public void reveal(){}

    @Override
    public String toString() {
        return description;
    }
}
