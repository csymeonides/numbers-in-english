package nie;

class NumberStringBuilder {
	private static final String[] SINGLE_DIGITS = new String[] {
		"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
	};

	private static final String[] TEN_TO_NINETEEN = new String[] {
		"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
	};

	private static final String[] TWENTY_TO_NINETY = new String[] {
		"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"
	};

	private final StringBuilder builder = new StringBuilder();

	void buildNumber(int input) {
		int thousandsDigit = input / 1000;
		if (thousandsDigit > 0) {
			builder.append(SINGLE_DIGITS[thousandsDigit]);
			builder.append(" thousand");
			buildRemainderIfNecessary(input % 1000);
		} else {
			int hundredsDigit = input / 100;
			if (hundredsDigit > 0) {
				builder.append(SINGLE_DIGITS[hundredsDigit]);
				builder.append(" hundred");
				buildRemainderIfNecessary(input % 100);
			} else {
				int tensDigit = input / 10;
				if (tensDigit == 0) {
					builder.append(SINGLE_DIGITS[input]);
				} else if (tensDigit == 1) {
					builder.append(TEN_TO_NINETEEN[input - 10]);
				} else {
					builder.append(TWENTY_TO_NINETY[tensDigit - 2]);
					buildRemainderIfNecessary(input % 10, " ");
				}
			}
		}
	}

	private void buildRemainderIfNecessary(int remainder) {
		String separator = remainder < 100 ? " and " : " ";
		buildRemainderIfNecessary(remainder, separator);
	}

	private void buildRemainderIfNecessary(int remainder, String separator) {
		if (remainder > 0) {
			builder.append(separator);
			buildNumber(remainder);
		}
	}

	void makeFirstLetterUpperCase() {
		char firstLetter = builder.charAt(0);
		builder.setCharAt(0, Character.toUpperCase(firstLetter));
	}

	@Override
	public String toString() {
		return builder.toString();
	}
}
