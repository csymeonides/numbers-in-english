package nie;

import static nie.errors.ErrorMessage.*;

import nie.errors.NumbersInEnglishException;

public class NumberConverter {
	private static final String ZERO = "Zero";
	private static final String MINUS = "Minus ";

	private String input;
	private final StringBuilder output = new StringBuilder();

	public NumberConverter(String input) {
		this.input = input;
	}

	public String convertNumberToEnglish() throws NumbersInEnglishException {
		validateInputAndHandleMinusSign();

		if ("0".equals(input)) {
			return ZERO;
		} else {
			UnsignedNumberConverter converter = new UnsignedNumberConverter(input, output);
			converter.convertUnsignedNumber();
			makeFirstLetterUpperCase();
			return output.toString();
		}
	}

	private void validateInputAndHandleMinusSign() {
		if (input == null || input.isEmpty()) {
			throw new NumbersInEnglishException(NoInputProvided);
		}

		if (!input.matches("-?\\d+")) {
			throw new NumbersInEnglishException(NonIntegerInput);
		}

		if (input.charAt(0) == '-') {
			input = input.substring(1);
			output.append(MINUS);
		}

		if (input.length() > UnsignedNumberConverter.MAX_DIGITS) {
			throw new NumbersInEnglishException(OutOfRange);
		}
	}

	void makeFirstLetterUpperCase() {
		char firstLetter = output.charAt(0);
		output.setCharAt(0, Character.toUpperCase(firstLetter));
	}
}