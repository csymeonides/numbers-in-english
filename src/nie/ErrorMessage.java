package nie;

public enum ErrorMessage {
	NoInputProvided("No input provided"),
	NonIntegerInput("Input was not an integer"),
	OutOfRange("Input is out of range - max number of digits is " + UnsignedNumberConverter.MAX_DIGITS);

	private final String message;

	private ErrorMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}