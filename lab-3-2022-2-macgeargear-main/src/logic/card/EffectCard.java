package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;


abstract class EffectCard extends BaseCard {
    // TODO Implement here
    public EffectCard(CardColor color, CardSymbol symbol) {
        super(color, symbol);
    }
    public abstract String performEffect();
    
    public String play() {
    	GameLogic.getInstance().setTopCard(this);

        // remove from current player's hand
//        int lenPlayerCard = GameLogic.getInstance().getCurrentPlayerHand().size();
        
        GameLogic.getInstance().getCurrentPlayerHand().remove(this);
		return this.performEffect();
    };


}
