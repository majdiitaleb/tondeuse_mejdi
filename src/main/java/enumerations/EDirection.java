package enumerations;

public enum EDirection {

	North("N"), East("E"), West("W"), South("S");

	private final String code;

	private String getCode() {
		return code;
	}

	EDirection(String code) {
		this.code = code;
	}


	public static EDirection getValueFromCode(final String code) {
		for (EDirection direction : EDirection.values()) {
			if (direction.getCode().equals(code)) {
				return direction;
			}
		}
		return null;
	}
}
