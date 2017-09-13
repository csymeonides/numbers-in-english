package nie;

public class NumbersInEnglish {
	public static void main(String... args) {
		if (args.length == 0) {
			System.err.println("No input provided");
		} else {
			String numberInEnglish = NumberConverter.convertNumberToEnglish(args[0]);
			System.out.println(numberInEnglish);
		}
	}
}