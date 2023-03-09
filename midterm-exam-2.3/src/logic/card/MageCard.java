package logic.card;

import logic.player.Player;

public class MageCard extends BaseCard {
    private Element mageType;

    public int countOrbCard(Player player, Element elementType) {
        int count = 0;
        for (BaseCard bc : player.getField()) {
            if (bc instanceof OrbCard) {
                OrbCard oc = (OrbCard) bc;    
                if (oc.getOrbType().equals(this.mageType)) {
                    count++;
                } 
            }
        }
        return count;
    }

    public MageCard(String name, int power, int health, Element mageType) {
        super(name, power, health);
        this.setMageType(mageType);
    }

    public void play(Player player) {
        int count = countOrbCard(player, this.getMageType());
        this.setPower(this.getPower() + count);

    }

    public boolean canPlay(Player player) {
        for (BaseCard bc : player.getField()) {
            if (bc instanceof OrbCard) {
                OrbCard oc = (OrbCard) bc;    
                if (oc.getOrbType().equals(this.mageType)) {
                    return true;
                } 
            }
        }
        return false;
    }


    public Element getMageType() {
        return this.mageType;
    }

    public void setMageType(Element mageType) {
        this.mageType = mageType;
    }

}
