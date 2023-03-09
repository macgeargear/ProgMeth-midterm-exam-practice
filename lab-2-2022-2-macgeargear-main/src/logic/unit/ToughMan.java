package logic.unit;


public class ToughMan extends BaseCompetitor{
    private int maxHp;
    public ToughMan(String name) {
        super(name);
        this.setHp(8);
        this.setPower(4);
        this.setMaxHp(8);
    }

    public ToughMan(String name, int hp, int power) {
        super(name, hp, power);
        this.setMaxHp(hp);
    }

    public void heal(int healHp) {
        int currentHp = this.getHp();
        currentHp += Math.max(healHp, 0);
        if (currentHp > this.getMaxHp()) {
            this.setHp(this.getMaxHp());     
        } else {
            this.setHp(currentHp);
        }

        
        
    }

    public void attack(BaseCompetitor enemy) {
        if (enemy.getType().equals("Sorcerer")) {
            enemy.setHp(enemy.getHp() - this.getPower() / 2);
        } else if (enemy.getType().equals("ToughMan") || enemy.getType().equals("BaseCompetitor")) {
            enemy.setHp(enemy.getHp() - this.getPower());
        } else {
            enemy.setHp(enemy.getHp() - (int) (this.getPower() * 1.5));
        }
    }

    /* -------------------------------------------------------------------------- */
    /*                                     getter & setter                                   */
    /* -------------------------------------------------------------------------- */

    public int getMaxHp() {
        return this.maxHp;
    }

    public void setMaxHp(int maxHp) {
        if (maxHp < 0) {
            this.maxHp = 0;
            this.setHp(0);
        } else if (maxHp < this.getHp()) {
            this.setHp(maxHp);
            this.maxHp = maxHp;
        } else {
            this.maxHp = maxHp;
        }
    }
}
