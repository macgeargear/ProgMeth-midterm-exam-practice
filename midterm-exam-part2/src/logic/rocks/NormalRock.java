package logic.rocks;

import logic.zombies.Zombie;

public class NormalRock {
    protected int damage;
    public NormalRock(int damage) {
        this.setDamage(damage);
    }

    public void setDamage(int damage) {
        this.damage = Math.max(0, damage);
    }

    public int getDamage() {
        return this.damage;
    }

    public int dealDamage(Zombie zombie) {
        if (zombie.getDefense() >= this.getDamage()) {
            return 0;
        } else {
            int def = zombie.getDefense();
            int damage = this.getDamage() - def;
            zombie.setHealth(zombie.getHealth() - damage);
            return Math.abs(damage);
        }

    }

    public String toString() {
        return "Normal Rock (" + this.getDamage() + ")";
    }

}
