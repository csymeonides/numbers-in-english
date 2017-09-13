package nie;

public class NumbersInEnglish {
	public static void main(String... args) {
		try {
			String numberInEnglish = NumberConverter.convertNumberToEnglish(args[0]);
			System.out.println(numberInEnglish);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}