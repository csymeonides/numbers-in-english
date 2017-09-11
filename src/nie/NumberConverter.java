package nie;

public class NumberConverter {
	public static String convertNumberToEnglish(String input) {
		Long inputAsLong = Long.valueOf(input);
		NumberStringBuilder builder = new NumberStringBuilder();
		builder.buildNumber(inputAsLong);
		builder.makeFirstLetterUpperCase();
		return builder.toString();
	}
}
