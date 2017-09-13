package nie;

import static nie.Constants.*;

class UnsignedNumberConverter {
	private String input;
	private final StringBuilder output;
	private String separator;
	private int nextDigits;

	UnsignedNumberConverter(String input, StringBuilder output) {
		this.input = input;
		this.output = output;
		this.separator = "";
		this.nextDigits = 0;
	}

	void convertUnsignedNumber() {
		while (hasMoreDigits()) {
			setNextDigits();
			if (nextDigits != 0) {
				convertHundredsDigit();
				convertRemainingDigits();
				addPowerOfThousand();
			}
			setFinalSeparator();
		}
	}

	private boolean hasMoreDigits() {
		return !input.isEmpty();
	}

	private void setNextDigits() {
		int numberOfNextDigits = ((input.length() - 1) % 3) + 1;
		nextDigits = Integer.valueOf(input.substring(0, numberOfNextDigits));
		input = input.substring(numberOfNextDigits);
	}

	private void convertHundredsDigit() {
		int hundredsDigit = nextDigits / 100;
		if (hundredsDigit != 0) {
			output.append(separator);
			output.append(SINGLE_DIGITS[hundredsDigit - 1]);
			output.append(" hundred");
			separator = " and ";
		}
	}

	private void convertRemainingDigits() {
		int tensDigit = (nextDigits % 100) / 10;
		if (tensDigit == 1) {
			output.append(separator);
			output.append(TEN_TO_NINETEEN[(nextDigits % 100) - 10]);
		} else {
			if (tensDigit > 1) {
				output.append(separator);
				output.append(TWENTY_TO_NINETY[tensDigit - 2]);
				separator = " ";
			}
			convertSingleDigit();
		}
	}

	private void convertSingleDigit() {
		int singleDigit = nextDigits % 10;
		if (singleDigit != 0) {
			output.append(separator);
			output.append(SINGLE_DIGITS[singleDigit - 1]);
		}
	}

	private void addPowerOfThousand() {
		if (hasMoreDigits()) {
			int powersOfThousandIndex = (input.length() - 1) / 3;
			output.append(" ");
			output.append(POWERS_OF_THOUSAND[powersOfThousandIndex]);
		}
	}

	private void setFinalSeparator() {
		if (hasMoreDigits() && input.length() <= 3 && Integer.valueOf(input) < 100) {
			separator = " and ";
		} else {
			separator = " ";
		}
	}
}
