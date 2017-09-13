package nie;

public class NumberConverter {
	private static final String ZERO = "Zero";
	private static final String MINUS = "Minus ";

	public static String convertNumberToEnglish(String input) {
		if ("0".equals(input)) {
			return ZERO;
		} else {
			boolean isNegativeNumber = input.charAt(0) == '-';
			if (isNegativeNumber) {
				input = input.substring(1);
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