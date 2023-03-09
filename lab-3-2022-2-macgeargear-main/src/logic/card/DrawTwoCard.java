package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;



public class DrawTwoCard extends EffectCard {

	public DrawTwoCard(CardColor color) {
		super(color, CardSymbol.DRAW_TWO);
	}

	@Override
	public String performEffect() {
		// TODO Auto-generated method stub
		GameLogic.getInstance().incrementDrawAmount(2);
		GameLogic.getInstance().goToNextPlayer();

		while(GameLogic.getInstance().getCurrentPlayerHand().size() == 0) {
			GameLogic.getInstance().goToNextPlayer();
		}
		String ans = "";
		for(BaseCard c: GameLogic.getInstance().getCurrentPlayerHand()) {
			if(c.getSymbol() == CardSymbol.DRAW_TWO || c.getSymbol() == CardSymbol.DRAW_FOUR) {
				ans = ("Player " + GameLogic.getInstance().getCurrentPlayer() + " played " + c + ". " + (GameLogic.getInstance().getCurrentPlayerHand().size()-1) + " cards remaining.\n").concat(c.play());
				System.out.println(ans);				
				return ans;
			}
		}
		for(BaseCard c: GameLogic.getInstance().draw(GameLogic.getInstance().getDrawAmount())) {
			GameLogic.getInstance().getCurrentPlayerHand().add(c);
		}
		ans = "Player " + GameLogic.getInstance().getCurrentPlayer() + " drew "+ GameLogic.getInstance().getDrawAmount() +" cards. " + GameLogic.getInstance().getCurrentPlayerHand().size() + " cards remaining.";
		GameLogic.getInstance().setDrawAmount(0);
		return ans;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getColor() + " " + this.getSymbol();
	}

	@Override
	public boolean canPlay() {
		// TODO Auto-generated method stub
		BaseCard topCard = GameLogic.getInstance().getTopCard();
		return topCard.getColor() == super.getColor() || topCard.getSymbol() == super.getSymbol();
	}
    // TODO Implement here


}
