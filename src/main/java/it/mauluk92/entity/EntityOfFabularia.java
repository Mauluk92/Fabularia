package it.mauluk92.entity;


import it.mauluk92.command.remote.impl.ManipulateRemoteEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public abstract class EntityOfFabularia {

    private EntityOfFabularia parent;
    private List<EntityOfFabularia> children = new ArrayList<>();
    private String description;
    private List<ManipulateRemoteEntity<? extends EntityOfFabularia>> commandList = new ArrayList<>();
    public void reveal(){
        commandList.forEach(ManipulateRemoteEntity::execute);
    }

    public void pushEntity(EntityOfFabularia entity){
        getChildren().add(entity);
        entity.setParent(this);
    }

    public void removeEntity(EntityOfFabularia entity){
        getChildren().remove(entity);
    }

    @Override
    public String toString() {
        return description;
    }
}
