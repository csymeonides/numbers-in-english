package nie;

import static nie.ErrorMessage.*;

public class NumberConverter {
	private static final String ZERO = "Zero";
	private static final String MINUS = "Minus ";

	public static String convertNumberToEnglish(String input) throws Exception {
		if (input == null || input.isEmpty()) {
			throw new NumbersInEnglishException(NoInputProvided);
		}

		if (!input.matches("-?\\d+")) {
			throw new NumbersInEnglishException(NonIntegerInput);
		}

		if ("0".equals(input)) {
			return ZERO;
		} else {
			boolean isNegativeNumber = input.charAt(0) == '-';
			if (isNegativeNumber) {
				input = input.substring(1);
			}

			if (input.length() > UnsignedNumberConverter.MAX_DIGITS) {
				throw new NumbersInEnglishException(OutOfRange);
			}

			UnsignedNumberConverter converter = new UnsignedNumberConverter(input);
			converter.convertUnsignedNumber();

			if (isNegativeNumber) {
				return MINUS + converter.getResult();
			} else {
				converter.makeFirstLetterUpperCase();
				return converter.getResult();
			}
		}
	}
}