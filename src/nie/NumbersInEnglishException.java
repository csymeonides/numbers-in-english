package nie;

public class NumbersInEnglishException extends RuntimeException {
	private static final long serialVersionUID = -5193607692450174003L;

	public NumbersInEnglishException(ErrorMessage errorMessage) {
		super(errorMessage.toString());
	}
}