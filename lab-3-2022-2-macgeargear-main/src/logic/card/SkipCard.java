package logic.card;


import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

//You CAN modify the first line
public class SkipCard extends EffectCard {
    // TODO Implement here
	public SkipCard(CardColor color) {
		super(color, CardSymbol.SKIP);
	}
	
	public String toString() {
		return "" + this.getColor().toString().toUpperCase() + " " + this.getSymbol();
	}

	@Override
	public String performEffect() {
		// TODO Auto-generated method stub
		int currentPlayerIndex = GameLogic.getInstance().getCurrentPlayer();
		while (GameLogic.getInstance().getPlayerHand(currentPlayerIndex + 1).size() == 0) {
			currentPlayerIndex++;
			GameLogic.getInstance().goToNextPlayer();
		}
		GameLogic.getInstance().goToNextPlayer();
		
		return "Skipped player " + (currentPlayerIndex+1);

	}

	@Override
	public boolean canPlay() {
        BaseCard topCard =  GameLogic.getInstance().getTopCard();
        return topCard.getColor().toString().equals(this.getColor().toString()) || topCard.getSymbol().toString().equals(this.getSymbol().toString());
	}

}
