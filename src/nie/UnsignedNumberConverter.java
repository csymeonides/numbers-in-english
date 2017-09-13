package nie;

import static nie.Constants.*;
import static nie.Separator.*;

class UnsignedNumberConverter {
	private String input;
	private final NumberStringBuilder builder;

	UnsignedNumberConverter(String input, NumberStringBuilder builder) {
		this.input = input;
		this.builder = builder;
	}

	void convertUnsignedNumber() {
		while (hasMoreDigits()) {
			int nextDigits = getNextDigits();
			if (nextDigits != 0) {
				ThreeDigitConverter.convertDigits(nextDigits, builder);
				addPowerOfThousandIfNecessary();
			}
			if (isFinalSetOfDigits()) {
				builder.setSeparator(AND);
			}
		}
	}

	private boolean hasMoreDigits() {
		return !input.isEmpty();
	}

	private int getNextDigits() {
		// TODO: either explain this bit, or split string into thousand groups
		int numberOfNextDigits = ((input.length() - 1) % 3) + 1;
		int nextDigits = Integer.valueOf(input.substring(0, numberOfNextDigits));
		input = input.substring(numberOfNextDigits);
		return nextDigits;
	}

	private void addPowerOfThousandIfNecessary() {
		if (hasMoreDigits()) {
			int powersOfThousandIndex = (input.length() - 1) / 3;
			builder.setSeparator(SPACE);
			builder.append(POWERS_OF_THOUSAND[powersOfThousandIndex]);
		}
	}

	private boolean isFinalSetOfDigits() {
		return input.length() == 3 && input.charAt(0) == '0';
	}
}
