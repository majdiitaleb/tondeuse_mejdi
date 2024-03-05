package modele;

import static enumerations.EDirection.East;
import static enumerations.EDirection.North;
import static enumerations.EDirection.South;
import static enumerations.EDirection.West;

import enumerations.EDeplacement;
import enumerations.EDirection;
import exceptions.DeplacementException;

public class Tondeuse {

	private final Grille pelouse;

	private final Case caseDepart;

	private Case caseFinale;

	private EDirection sens;

	public Case getCaseFinale() {
		return caseFinale;
	}

	public Case getCaseDepart() {
		return caseDepart;
	}

	public Grille getPelouse() {
		return pelouse;
	}

	public EDirection getSens() {
		return sens;
	}

	public Tondeuse(int lignes, int colonnes, int posX, int posY, EDirection sens) {
		this.pelouse = new Grille(lignes, colonnes);
		this.caseDepart = this.pelouse.getCase(posX, posY);
		this.caseFinale = this.pelouse.getCase(posX, posY);
		this.sens = sens;
	}

	public void deplacement(EDeplacement deplacement) throws DeplacementException {
		switch (deplacement) {
		case A:
			deplacerEnAvant();
			break;
		case D:
			deplacerDroite();
			break;
		case G:
			deplacerGauche();
			break;
		default:
			break;
		}
	}

	private void deplacerDroite() {
		switch (sens) {
		case North:
			sens = East;
			break;
		case East:
			sens = South;
			break;
		case West:
			sens = North;
			break;
		case South:
			sens = West;
			break;
		default:
			break;
		}
	}

	private void deplacerGauche() {
		switch (sens) {
		case North:
			sens = West;
			break;
		case East:
			sens = North;
			break;
		case West:
			sens = South;
			break;
		case South:
			sens = East;
			break;
		default:
			break;
		}
	}

	private void deplacerEnAvant() throws DeplacementException {
		int x = caseFinale.getX();
		int y = caseFinale.getY();
		switch (sens) {
		case North:
			y++;
			break;
		case East:
			x++;
			break;
		case West:
			x--;
			break;
		case South:
			y--;
			break;
		default:
			break;
		}
		try {
			this.caseFinale = this.getPelouse().getCase(x, y);
		} catch (Exception e) {
			throw new DeplacementException("Déplacement Impossible !");
		}
	}

	@Override
	public String toString() {
		return "Ma position finale est X = " + this.getCaseFinale().getX() + ", Y = " + this.getCaseFinale().getY()
				+ " et je suis orientée : " + this.sens;
	}


}
