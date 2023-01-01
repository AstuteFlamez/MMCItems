package mandomc.mmcitems.vehicles;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Vehicle {

    private Player pilot;
    private Player gunner;
    private Entity seat1;
    private Entity seat2;
    private Entity model;
    private int seat1Item;
    private int seat2Item;


    public Vehicle(){
    }

    public Player getPilot() {
        return pilot;
    }

    public void setPilot(Player pilot) {
        this.pilot = pilot;
    }

    public Player getGunner() {
        return gunner;
    }

    public void setGunner(Player gunner) {
        this.gunner = gunner;
    }

    public Entity getSeat1() {
        return seat1;
    }

    public void setSeat1(Entity seat1) {
        this.seat1 = seat1;
    }

    public Entity getSeat2() {
        return seat2;
    }

    public void setSeat2(Entity seat2) {
        this.seat2 = seat2;
    }

    public Entity getModel() {
        return model;
    }

    public void setModel(Entity model) {
        this.model = model;
    }

    public int getSeat1Item(){return seat1Item;}

    public void setSeat1Item(int seat1Item){this.seat1Item = seat1Item;}

    public int getSeat2Item(){return seat2Item;}

    public void setSeat2Item(int seat2Item){this.seat2Item = seat2Item;}

}
