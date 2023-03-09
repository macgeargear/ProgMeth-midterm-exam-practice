package logic.unit;


public class Tiger extends BaseCompetitor{
    public Tiger(String name) {
        super(name);
        this.setHp(7);
        this.setPower(5);
    }

    public Tiger(String name, int hp, int power) {
        super(name, hp, power);
    }

    public void heal(int healHp) {
        this.setHp(this.getHp() + healHp);
    }

    public void train(int addPower) {
        this.setPower(this.getPower() + Math.max(0, addPower));    
    }

    public void attack(BaseCompetitor enemy) {
        if (enemy.getType().equals("ToughMan")) {
            enemy.setHp(enemy.getHp() - this.getPower() / 2);
        } else if (enemy.getType().equals("Tiger") || enemy.getType().equals("BaseCompetitor")) {
            enemy.setHp(enemy.getHp() - this.getPower());
        } else {
            enemy.setHp((int) (enemy.getHp() - (this.getPower() * 1.5 )));
        }
    }
}
