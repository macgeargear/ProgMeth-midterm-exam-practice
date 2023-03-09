package test.student;

import logic.card.BaseCard;
import logic.card.ChangeColorCard;
import logic.card.NumberCard;
import logic.card.SkipCard;
import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {

    ArrayList<BaseCard> hand0;
    ArrayList<BaseCard> hand1;

    NumberCard c1;
    SkipCard c2;
    NumberCard c3;
    ChangeColorCard c4;

    @BeforeEach
    void setup() {
        c1 = new NumberCard(CardColor.YELLOW, CardSymbol.NINE);
        c2 = new SkipCard(CardColor.YELLOW);
        c3 = new NumberCard(CardColor.RED, CardSymbol.NINE);
        c4 = new ChangeColorCard();
    }

    @AfterEach
    void tearDown() {
        GameLogic.clearInstance();
    }

    @Test
    void testIsHandPlayableTrue() {
        // TODO Implement here
    	GameLogic gameInstance = GameLogic.getInstance(1);
    	
//    	same color
    	gameInstance.getPlayerHand(0).add(c1);
    	gameInstance.setTopCard(c2);
    	assertEquals(true, gameInstance.isHandPlayable(0));
    	
//    	same symbol
    	gameInstance.getPlayerHand(0).add(c3);
    	assertEquals(true, gameInstance.isHandPlayable(0));
    }

    @Test
    void testIsHandPlayableFalse() {
        // TODO Implement here
    	GameLogic gameInstance = GameLogic.getInstance(1);
    	
//    	same color
    	gameInstance.getPlayerHand(0).add(c3);
    	gameInstance.setTopCard(c2);
    	assertEquals(false, gameInstance.isHandPlayable(0));

    }

    @Test
    void testDrawLessThanDeck() {
        // TODO Implement here
    	GameLogic gameInstance = GameLogic.getInstance(4);
		for (int i = 0; i < 17; i++)
			gameInstance.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
		
		assertEquals(5, gameInstance.draw(5).size());
    }

    @Test
    void testDrawMoreThanDeck() {
        // TODO Implement here
    	GameLogic gameInstance = GameLogic.getInstance(4);
		for (int i = 0; i < 2; i++)
			gameInstance.getDeck().add(new NumberCard(CardColor.randomColor(), CardSymbol.randomSymbol()));
		
		assertEquals(2, gameInstance.draw(5).size());

    }

}

