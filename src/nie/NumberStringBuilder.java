package nie;

import static nie.Separator.*;

class NumberStringBuilder {
	private final StringBuilder builder = new StringBuilder();
	private Separator separator = NONE;

	void append(String word) {
		builder.append(separator);
		builder.append(word);
	}

	String getResult() {
		makeFirstLetterUpperCase();
		return builder.toString();
	}

	private void makeFirstLetterUpperCase() {
		char firstLetter = builder.charAt(0);
		builder.setCharAt(0, Character.toUpperCase(firstLetter));
	}

	void setSeparator(Separator separator) {
		this.separator = separator;
	}
}
