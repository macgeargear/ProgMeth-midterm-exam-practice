package test.student;

import static org.junit.Assert.*;

import org.junit.jupiter.api.*;

import logic.card.*;
import logic.game.*;

public class ChangeColorCardTest {
    ChangeColorCard c1;
    NumberCard c2;
    ChangeColorCard c3;
    SkipCard c4;
    NumberCard c5;

    @BeforeEach
    public void setup() {
        c1 = new ChangeColorCard();
        c2 = new NumberCard(CardColor.RED, CardSymbol.NINE);
        c3 = new ChangeColorCard();
        c4 = new SkipCard(CardColor.RED);
        c5 = new NumberCard(CardColor.BLUE, CardSymbol.FIVE);
    }

    @AfterEach
    public void tearDown() {
        GameLogic.clearInstance();
    }

    @Test
    public void testConstructor() {
        assertNull(c1.getColor());
        assertEquals(CardSymbol.CHANGE_COLOR, c1.getSymbol());
    }

    @Test
    public void testToString() {
        assertEquals("CHANGE COLOR", c1.toString());
        c1.setColor(CardColor.YELLOW);
        assertEquals("CHANGE COLOR (YELLOW color selected)", c1.toString());
    }

    @Test
    public void testCanPlay() {
        GameLogic gameInstance = GameLogic.getInstance(1);

        gameInstance.setTopCard(c2);
        assertTrue(c1.canPlay());

        gameInstance.setTopCard(c3);
        assertTrue(c1.canPlay());

        gameInstance.setTopCard(c4);
        assertTrue(c1.canPlay());

        gameInstance.setTopCard(c5);
        assertTrue(c1.canPlay());
    }

    @Test
    public void testPerformEffectHasColor() {
        // TODO Implement here


    }

    @Test
    public void testPerformEffectNoColor() {
        // TODO Implement here


    }

    @Test
    void testPerformEffectNoCard() {
        // TODO Implement here


    }

    @Test
    void testPlay() {
        GameLogic gameInstance = GameLogic.getInstance(2);
        gameInstance.getPlayerHand(0).add(c1);
        gameInstance.getPlayerHand(1).add(c3);
        gameInstance.getPlayerHand(1).add(c5);

        String message = c1.play();

        assertEquals(c1, gameInstance.getTopCard());
        assertEquals(0, gameInstance.getPlayerHand(0).size());
        assertEquals(CardColor.RED, c1.getColor());
        assertEquals("Set color to RED", message);

        gameInstance.goToNextPlayer();

        message = c3.play();

        assertEquals(c3, gameInstance.getTopCard());
        assertEquals(1, gameInstance.getPlayerHand(1).size());
        assertEquals(CardColor.BLUE, c3.getColor());
        assertEquals("Set color to BLUE", message);
    }

}
