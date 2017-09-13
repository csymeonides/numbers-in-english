package nie;

import static nie.Constants.*;

class UnsignedNumberConverter {
	private String input;
	private final StringBuilder output;
	private String separator;

	UnsignedNumberConverter(String input, StringBuilder output) {
		this.input = input;
		this.output = output;
		this.separator = "";
	}

	void convertUnsignedNumber() {
		int numberOfDigits = input.length();
		int numberOfTopDigits = ((numberOfDigits - 1) % 3) + 1;
		int topDigits = Integer.valueOf(input.substring(0, numberOfTopDigits));
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
			output.append(separator);
			int hundredsDigit = digits / 100;
			if (hundredsDigit > 0) {
				output.append(SINGLE_DIGITS[hundredsDigit - 1]);
				output.append(" hundred");
				separator = " and ";
				convertAtMostThreeDigits(digits % 100);
			} else {
				int tensDigit = digits / 10;
				if (tensDigit > 1) {
					output.append(TWENTY_TO_NINETY[tensDigit - 2]);
					separator = " ";
					convertAtMostThreeDigits(digits % 10);
				} else if (tensDigit == 1) {
					output.append(TEN_TO_NINETEEN[digits - 10]);
				} else {
					output.append(SINGLE_DIGITS[digits - 1]);
				}
			}
		}
	}

	private void addPowerOfThousand(int numberOfDigits) {
		int powersOfThousandIndex = ((numberOfDigits - 1) / 3) - 1;
		output.append(" ");
		output.append(POWERS_OF_THOUSAND[powersOfThousandIndex]);
	}

	private void convertRemainder(int offset) {
		input = input.substring(offset);
		separator = " ";
		if (input.length() <= 3 && Integer.valueOf(input) < 100) {
			separator = " and ";
		}
		convertUnsignedNumber();
	}
}
