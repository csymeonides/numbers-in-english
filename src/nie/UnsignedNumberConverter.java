package nie;

import static nie.Constants.*;
import static nie.Separator.*;

class UnsignedNumberConverter {
	static void convertToEnglish(String input, NumberStringBuilder builder) {
		UnsignedNumberConverter converter = new UnsignedNumberConverter(input, builder);
		converter.convertToEnglish();
	}

	private String input;
	private final NumberStringBuilder builder;

	private UnsignedNumberConverter(String input, NumberStringBuilder builder) {
		this.input = input;
		this.builder = builder;
	}

	private void convertToEnglish() {
		while (hasMoreDigits()) {
			int nextDigits = getNextDigitsAndShiftInput();
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

	// Should return the digits from the next "thousands group" i.e. at most 3 digits
	// Possible improvement: split the input string into "thousands groups" from the beginning and iterate over them
	private int getNextDigitsAndShiftInput() {
		int numberOfNextDigits = ((input.length() - 1) % 3) + 1;
		int nextDigits = Integer.valueOf(input.substring(0, numberOfNextDigits));
		input = input.substring(numberOfNextDigits);
		return nextDigits;
	}

	private void addPowerOfThousandIfNecessary() {
		if (hasMoreDigits()) {
			int powersOfThousandIndex = (input.length() - 1) / 3;
			builder.appendWithSpace(POWERS_OF_THOUSAND[powersOfThousandIndex]);
		}
	}

	private boolean isFinalSetOfDigits() {
		return input.length() == 3 && input.charAt(0) == '0';
	}
}
