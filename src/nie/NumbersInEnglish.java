package nie;

import nie.errors.NumbersInEnglishException;

public class NumbersInEnglish {
	public static void main(String... args) {
		try {
			String numberInEnglish = new NumberConverter(args[0]).convertNumberToEnglish();
			System.out.println(numberInEnglish);
		} catch (NumbersInEnglishException e) {
			System.err.println(e.getMessage());
		}
	}
}