package logic.rocks;

import logic.zombies.Zombie;

public class PoisonRock extends NormalRock {
    private int damageOverTime;

    public PoisonRock(int damage, int damageOverTime) {
        super(damage);
        this.setDamageOverTime(damageOverTime);
    }

    public void setDamageOverTime(int dmgOverTime) {
        this.damageOverTime = Math.max(0, dmgOverTime);
    }

    public int getDamageOverTime() {
        return this.damageOverTime;
    }

    @Override
    public int dealDamage(Zombie zombie) {
        zombie.setDecay(zombie.getDecay() + damageOverTime);
        int dmg = super.dealDamage(zombie);
        return dmg;
    }

    @Override
    public String toString() {
        return "Poison Rock (" + this.getDamage() + ", DoT = " + this.getDamageOverTime() + ")";
    }

}
