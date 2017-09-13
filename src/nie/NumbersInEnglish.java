package nie;

import nie.errors.NumbersInEnglishException;

public class NumbersInEnglish {
	public static void main(String... args) {
		try {
			String numberInEnglish = NumberConverter.convertToEnglish(args[0]);
			System.out.println(numberInEnglish);
		} catch (NumbersInEnglishException e) {
			System.err.println(e.getMessage());
		}
	}
}