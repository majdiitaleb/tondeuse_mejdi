package modele;

import static enumerations.EDeplacement.A;
import static enumerations.EDeplacement.D;
import static enumerations.EDeplacement.G;
import static enumerations.EDirection.East;
import static enumerations.EDirection.North;
import static enumerations.EDirection.South;
import static enumerations.EDirection.West;
import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import exceptions.DeplacementException;

public class TondeuseTest {

	public Tondeuse tondeuse;

	@Test
	public void testTondeusePosition1_2() {
		this.tondeuse = new Tondeuse(5, 5, 1, 2, North);
		assertEquals(1, this.tondeuse.getCaseDepart().getX());
		assertEquals(2, this.tondeuse.getCaseDepart().getY());
	}

	@Test
	public void testTondeusePosition3_4() {
		this.tondeuse = new Tondeuse(5, 5, 3, 4, North);
		assertEquals(3, this.tondeuse.getCaseDepart().getX());
		assertEquals(4, this.tondeuse.getCaseDepart().getY());
	}

	@Test
	public void testTondeusePosition4_5() {
		this.tondeuse = new Tondeuse(5, 5, 4, 5, North);
		assertEquals(4, this.tondeuse.getCaseDepart().getX());
		assertEquals(5, this.tondeuse.getCaseDepart().getY());
	}

	@Test
	public void testDeplacementTondeuse1() throws DeplacementException {
		this.tondeuse = new Tondeuse(5, 5, 1, 2, North);
		assertEquals(1, this.tondeuse.getCaseDepart().getX());
		assertEquals(2, this.tondeuse.getCaseDepart().getY());
		assertEquals(North, this.tondeuse.getSens());
		this.tondeuse.deplacement(G);
		assertEquals(West, this.tondeuse.getSens());
		this.tondeuse.deplacement(A);
		assertEquals(0, this.tondeuse.getCaseFinale().getX());
		assertEquals(2, this.tondeuse.getCaseFinale().getY());
		this.tondeuse.deplacement(G);
		assertEquals(South, this.tondeuse.getSens());
		this.tondeuse.deplacement(A);
		assertEquals(0, this.tondeuse.getCaseFinale().getX());
		assertEquals(1, this.tondeuse.getCaseFinale().getY());
		this.tondeuse.deplacement(G);
		assertEquals(East, this.tondeuse.getSens());
		this.tondeuse.deplacement(A);
		assertEquals(1, this.tondeuse.getCaseFinale().getX());
		assertEquals(1, this.tondeuse.getCaseFinale().getY());
		this.tondeuse.deplacement(G);
		assertEquals(North, this.tondeuse.getSens());
		this.tondeuse.deplacement(A);
		assertEquals(1, this.tondeuse.getCaseFinale().getX());
		assertEquals(2, this.tondeuse.getCaseFinale().getY());
		this.tondeuse.deplacement(A);
		assertEquals(1, this.tondeuse.getCaseFinale().getX());
		assertEquals(3, this.tondeuse.getCaseFinale().getY());
		assertEquals(North, this.tondeuse.getSens());
	}

	@Test
	public void testDeplacementTondeuse2() throws DeplacementException {
		this.tondeuse = new Tondeuse(5, 5, 3, 3, East);
		assertEquals(3, this.tondeuse.getCaseDepart().getX());
		assertEquals(3, this.tondeuse.getCaseDepart().getY());
		assertEquals(East, this.tondeuse.getSens());
		this.tondeuse.deplacement(A);
		this.tondeuse.deplacement(A);
		this.tondeuse.deplacement(D);
		this.tondeuse.deplacement(A);
		this.tondeuse.deplacement(A);
		this.tondeuse.deplacement(D);
		this.tondeuse.deplacement(A);
		this.tondeuse.deplacement(D);
		this.tondeuse.deplacement(D);
		this.tondeuse.deplacement(A);
		assertEquals(5, this.tondeuse.getCaseFinale().getX());
		assertEquals(1, this.tondeuse.getCaseFinale().getY());
		assertEquals(East, this.tondeuse.getSens());
	}

	@Test
	public void testDeplacementImpossible() throws DeplacementException {
		this.tondeuse = new Tondeuse(5, 5, 0, 0, South);
		try {
			this.tondeuse.deplacement(A);
		} catch (DeplacementException e) {
			assertEquals("Déplacement Impossible !", e.getMessage());
		}
	}
}
