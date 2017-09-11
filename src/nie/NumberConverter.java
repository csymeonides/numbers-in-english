package nie;

public class NumberConverter {
	public static String convertNumberToEnglish(String input) {
		Integer inputAsInt = Integer.valueOf(input);
		NumberStringBuilder builder = new NumberStringBuilder();
		builder.buildNumber(inputAsInt);
		builder.makeFirstLetterUpperCase();
		return builder.toString();
	}
}
