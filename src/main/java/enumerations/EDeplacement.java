package enumerations;

public enum EDeplacement {

	A(1), G(0), D(0);

	private final int nombreCases;

	public int getNombreCases() {
		return nombreCases;
	}

	EDeplacement(int nombreCases) {
		this.nombreCases = nombreCases;
	}


}
