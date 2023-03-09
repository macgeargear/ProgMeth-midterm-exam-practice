package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;


//You CAN modify the first line
public class ChangeColorCard extends EffectCard {

	public ChangeColorCard() {
		super(null, CardSymbol.CHANGE_COLOR);
	}
	
	public String toString() {
		if (this.getColor() == null) {
			return this.getSymbol()+"";
		} else {
			return this.getSymbol() + " (" + this.getColor() + " color selected)";
		}
	}

	@Override
	public String performEffect() {
		GameLogic instance = GameLogic.getInstance();
		// TODO Auto-generated method stub
		CardColor color = CardColor.RED;
		if (instance.getCurrentPlayerHand().size() != 0 && instance.getCurrentPlayerHand().get(0).getColor() != null) {
			color = instance.getCurrentPlayerHand().get(0).getColor();
		}
		this.setColor(color);
		instance.setTopCard(this);
		return "Set color to " + color;
	}


	@Override
	public boolean canPlay() {
		// TODO Auto-generated method stub
		return true;
	}


}
