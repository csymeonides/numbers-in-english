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

	private static final String[] POWERS_OF_THOUSAND = new String[] {
		"thousand", "million", "billion", "trillion", "quadrillion", "quintillion"
	};

	private static final long MAX_POWER_OF_THOUSAND = (long) Math.pow(10, POWERS_OF_THOUSAND.length * 3);

	private final StringBuilder builder = new StringBuilder();

	void buildNumber(long input) {
		long divisor = MAX_POWER_OF_THOUSAND;
		int powersOfThousandIndex = POWERS_OF_THOUSAND.length - 1;
		long topDigits = input / divisor;
		while (topDigits == 0 && powersOfThousandIndex >= 0) {
			divisor /= 1000;
			topDigits = input / divisor;
			powersOfThousandIndex--;
		}

		if (powersOfThousandIndex >= 0) {
			buildNumber(topDigits);
			builder.append(" ");
			builder.append(POWERS_OF_THOUSAND[powersOfThousandIndex]);
			buildRemainderIfNecessary(input % divisor);
		} else {
			buildLastThreeDigits((int) input);
		}
	}

	private void buildLastThreeDigits(int input) {
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

	private void buildRemainderIfNecessary(long remainder) {
		String separator = remainder < 100 ? " and " : " ";
		buildRemainderIfNecessary(remainder, separator);
	}

	private void buildRemainderIfNecessary(long remainder, String separator) {
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
