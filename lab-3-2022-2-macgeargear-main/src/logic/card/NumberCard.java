package logic.card;

import logic.game.CardSymbol;
import logic.game.CardColor;
import logic.game.GameLogic;


public class NumberCard extends BaseCard {
    // TODO Implement here
    public NumberCard(CardColor color, CardSymbol symbol) {
        super(color, symbol);
    }

    public String toString() {
        return "" + this.getColor().toString().toUpperCase() + " " + this.getSymbol().toString().toUpperCase();
    }

    public boolean canPlay() {
        // this.getColor().toString().equals();
        BaseCard topCard =  GameLogic.getInstance().getTopCard();
        return topCard.getColor().toString().equals(this.getColor().toString()) || topCard.getSymbol().toString().equals(this.getSymbol().toString());
    }

    public String play() {
//        BaseCard newCard = new NumberCard(this.getColor(), this.getSymbol());
        GameLogic.getInstance().setTopCard(this);

        // remove from current player's hand
        int lenPlayerCard = GameLogic.getInstance().getCurrentPlayerHand().size();
        
        GameLogic.getInstance().getCurrentPlayerHand().remove(lenPlayerCard-1);
        return null;
    }

}
