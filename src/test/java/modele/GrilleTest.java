package modele;
import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class GrilleTest {

	private Grille grille;

	@Test
	public void testInitGrille() {
		this.grille = new Grille(5, 5);
		assertEquals(36, grille.getTaille());
	}
}
