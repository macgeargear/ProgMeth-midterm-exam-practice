package logic.card;

import logic.player.Player;

public class RobotCard extends BaseCard{
    private int energyCost;

    public RobotCard(String name, int power, int health, int energyCost) {
        super(name, power, health);
        this.setEnergyCost(energyCost);
    }

    @Override
    public void play(Player player) {
        player.setEnergy(player.getEnergy() - energyCost);
        
    }

    @Override
    public boolean canPlay(Player player) {
        return player.getEnergy() >= this.getEnergyCost();
    }


    public int getEnergyCost() {
        return this.energyCost;
    }

    public void setEnergyCost(int energyCost) {
        this.energyCost = Math.max(0, energyCost);
    }

}
