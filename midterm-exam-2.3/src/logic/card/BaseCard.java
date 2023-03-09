package logic.card;

import logic.player.Player;

public abstract class BaseCard {
    private String name;
    private int power;
    private int health;

    public BaseCard(String name, int power, int health) {
        this.setHealth(health);
        this.setName(name);
        this.setPower(power);
    }

    public abstract void play(Player player);
    
    public abstract boolean canPlay(Player player);

    public int attack(BaseCard target) {
       int remainHealth = Math.max(0, target.getHealth() - this.getPower());
       int targetHealth = target.getHealth();
       target.setHealth(remainHealth);
       if (this.getPower() <= targetHealth) {
        return 0;
       } else {
        return this.getPower() - targetHealth;
       }
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = Math.max(0, power);
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, health);
    }

}
