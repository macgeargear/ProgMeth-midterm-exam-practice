package test.grader;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import logic.game.*;
import logic.rocks.*;
import logic.zombies.*;

public class GameManagerTest {
	
	@Test
	void testAttackZombie() {
		Player terry = new Player(250);
		GameManager.initializeManager(terry);
		
		// PierceRock rockA = new PierceRock(25);

		NormalRock rockA = new NormalRock(10);
		NormalRock rockB = new NormalRock(13);
		
		GameManager.currentRock = rockA;
		GameManager.nextRock = rockB;
		
		Zombie zombie = new Zombie(200, 10, 2);
		
		// before 25
		assertEquals(8, GameManager.attackZombie(zombie));
		// before 175
		assertEquals(192, zombie.getHealth());
		// remove this because do not 
		assertEquals(rockB, GameManager.currentRock);
	}
	
}
