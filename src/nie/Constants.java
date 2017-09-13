package nie;

public class Constants {
	public static final String ZERO = "Zero";
	public static final String MINUS = "Minus ";
	public static final String HUNDRED = "hundred";

	public static final String[] SINGLE_DIGITS = new String[] {
		"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
	};

	public static final String[] TEN_TO_NINETEEN = new String[] {
		"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
	};

	public static final String[] TWENTY_TO_NINETY = new String[] {
		"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"
	};

	public static final String[] POWERS_OF_THOUSAND = new String[] {
		"thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion", "septillion", "octillion", "nonillion"
	};

	public static final int MAX_DIGITS = (POWERS_OF_THOUSAND.length + 1) * 3;
}
