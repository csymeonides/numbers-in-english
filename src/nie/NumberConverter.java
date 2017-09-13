package nie;

import static nie.Constants.*;
import static nie.errors.ErrorMessage.*;

import nie.errors.NumbersInEnglishException;

class NumberConverter {
	static String convertToEnglish(String input) {
		NumberConverter converter = new NumberConverter(input);
		converter.validateInputAndHandleMinusSign();
		return converter.getResult();
	}

	private String input;
	private final NumberStringBuilder builder;

	private NumberConverter(String input) {
		this.input = input;
		this.builder = new NumberStringBuilder();
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
			builder.append(MINUS);
		}

		if (input.length() > MAX_DIGITS) {
			throw new NumbersInEnglishException(OutOfRange);
		}
	}

	private String getResult() throws NumbersInEnglishException {
		if ("0".equals(input)) {
			return ZERO;
		} else {
			UnsignedNumberConverter.convertToEnglish(input, builder);
			return builder.getResult();
		}
	}
}