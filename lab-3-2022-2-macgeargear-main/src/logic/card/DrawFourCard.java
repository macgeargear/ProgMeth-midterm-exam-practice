package logic.card;

import logic.game.CardSymbol;
import logic.game.GameLogic;


//You CAN modify the first line

public class DrawFourCard extends ChangeColorCard {
	// TODO Implement here
	public DrawFourCard() {
		super();
		super.setSymbol(CardSymbol.DRAW_FOUR);
	}

	public String performEffect() {
		String result = super.performEffect()+"\n";
		GameLogic.getInstance().incrementDrawAmount(4);

		GameLogic.getInstance().goToNextPlayer();
		while(GameLogic.getInstance().getCurrentPlayerHand().size() == 0) {
			GameLogic.getInstance().goToNextPlayer();
		}
		for(BaseCard c: GameLogic.getInstance().getCurrentPlayerHand()) {
			if(c.getSymbol() == CardSymbol.DRAW_FOUR) {
				return (result + "Player " + GameLogic.getInstance().getCurrentPlayer() + " played " + c + ". " + (GameLogic.getInstance().getCurrentPlayerHand().size()-1) + " cards remaining.\n").concat(c.play());
			}
		}
		for(BaseCard c: GameLogic.getInstance().draw(GameLogic.getInstance().getDrawAmount())) {
			GameLogic.getInstance().getCurrentPlayerHand().add(c);
		}
		result += "Player " + GameLogic.getInstance().getCurrentPlayer() + " drew "+ GameLogic.getInstance().getDrawAmount() +" cards. " + GameLogic.getInstance().getCurrentPlayerHand().size() + " cards remaining.";
		GameLogic.getInstance().setDrawAmount(0);
		return result;
	}

}
