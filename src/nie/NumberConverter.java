package nie;

import static nie.Constants.*;
import static nie.errors.ErrorMessage.*;

import nie.errors.NumbersInEnglishException;

public class NumberConverter {
	private String input;
	private final NumberStringBuilder builder;

	public NumberConverter(String input) {
		this.input = input;
		this.builder = new NumberStringBuilder();
	}

	public String convertNumberToEnglish() throws NumbersInEnglishException {
		validateInputAndHandleMinusSign();

		if ("0".equals(input)) {
			return ZERO;
		} else {
			UnsignedNumberConverter converter = new UnsignedNumberConverter(input, builder);
			converter.convertUnsignedNumber();
			return builder.getResult();
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
			builder.append(MINUS);
		}

		if (input.length() > MAX_DIGITS) {
			throw new NumbersInEnglishException(OutOfRange);
		}
	}
}