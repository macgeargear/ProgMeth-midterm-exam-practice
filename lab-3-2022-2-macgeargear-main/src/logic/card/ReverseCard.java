package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;
import logic.game.PlayDirection;

public class ReverseCard extends EffectCard {
    // TODO Implement here
    public ReverseCard(CardColor color) {
        super(color, CardSymbol.REVERSE);
    }
    
    @Override
    public String toString() {
    	return "" + this.getColor().toString().toUpperCase() + " " + this.getSymbol();
    }
    
    @Override
    public boolean canPlay() {
    	  BaseCard topCard =  GameLogic.getInstance().getTopCard();
          return topCard.getColor().toString().equals(this.getColor().toString()) || topCard.getSymbol().toString().equals(this.getSymbol().toString());
    }
    
    @Override
    public String performEffect() {
    	PlayDirection currentDirection = GameLogic.getInstance().getPlayDirection();
    	GameLogic.getInstance().setPlayDirection(currentDirection.getOpposite());
    	return "Set direction to " + currentDirection.getOpposite();
    }

}
