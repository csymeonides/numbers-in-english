package nie;

enum Separator {
	NONE(""),
	SPACE(" "),
	AND(" and ");

	private final String separatorString;

	private Separator(String separatorString) {
		this.separatorString = separatorString;
	}

	@Override
	public String toString() {
		return separatorString;
	}
}