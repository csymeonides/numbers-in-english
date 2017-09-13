package nie;

public class UnsignedNumberConverter {
	private static final String[] SINGLE_DIGITS = new String[] {
		"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
	};

	private static final String[] TEN_TO_NINETEEN = new String[] {
		"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
	};

	private static final String[] TWENTY_TO_NINETY = new String[] {
		"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"
	};

	private static final String[] POWERS_OF_THOUSAND = new String[] {
		"thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion", "septillion", "octillion", "nonillion"
	};

	public static final int MAX_DIGITS = (POWERS_OF_THOUSAND.length + 1) * 3;

	private final StringBuilder builder = new StringBuilder();
	private String digits;
	private String separator;

	UnsignedNumberConverter(String digits) {
		this.digits = digits;
		this.separator = "";
	}

	void convertUnsignedNumber() {
		int numberOfDigits = digits.length();
		int numberOfTopDigits = ((numberOfDigits - 1) % 3) + 1;
		int topDigits = Integer.valueOf(digits.substring(0, numberOfTopDigits));
		convertAtMostThreeDigits(topDigits);

		if (numberOfDigits > 3) {
			if (topDigits != 0) {
				addPowerOfThousand(numberOfDigits);
			}
			convertRemainder(numberOfTopDigits);
		}
	}

	private void convertAtMostThreeDigits(int digits) {
		if (digits != 0) {
			builder.append(separator);
			int hundredsDigit = digits / 100;
			if (hundredsDigit > 0) {
				builder.append(SINGLE_DIGITS[hundredsDigit - 1]);
				builder.append(" hundred");
				separator = " and ";
				convertAtMostThreeDigits(digits % 100);
			} else {
				int tensDigit = digits / 10;
				if (tensDigit > 1) {
					builder.append(TWENTY_TO_NINETY[tensDigit - 2]);
					separator = " ";
					convertAtMostThreeDigits(digits % 10);
				} else if (tensDigit == 1) {
					builder.append(TEN_TO_NINETEEN[digits - 10]);
				} else {
					builder.append(SINGLE_DIGITS[digits - 1]);
				}
			}
		}
	}

	private void addPowerOfThousand(int numberOfDigits) {
		int powersOfThousandIndex = ((numberOfDigits - 1) / 3) - 1;
		builder.append(" ");
		builder.append(POWERS_OF_THOUSAND[powersOfThousandIndex]);
	}

	private void convertRemainder(int offset) {
		digits = digits.substring(offset);
		separator = " ";
		if (digits.length() <= 3 && Integer.valueOf(digits) < 100) {
			separator = " and ";
		}
		convertUnsignedNumber();
	}

	void makeFirstLetterUpperCase() {
		char firstLetter = builder.charAt(0);
		builder.setCharAt(0, Character.toUpperCase(firstLetter));
	}

	String getResult() {
		return builder.toString();
	}
}
