package nie;

import static nie.Constants.*;
import static nie.Separator.*;

class ThreeDigitConverter {
	private final NumberStringBuilder builder;

	static void convertDigits(int digits, NumberStringBuilder builder) {
		ThreeDigitConverter converter = new ThreeDigitConverter(digits, builder);
		converter.convertHundredsDigit(digits / 100);
		converter.convertRemainingDigits(digits % 100);
	}

	private ThreeDigitConverter(int digits, NumberStringBuilder builder) {
		this.builder = builder;
	}

	private void convertHundredsDigit(int hundredsDigit) {
		if (hundredsDigit != 0) {
			builder.append(SINGLE_DIGITS[hundredsDigit - 1] + " hundred");
			builder.setSeparator(AND);
		}
	}

	private void convertRemainingDigits(int remainingDigits) {
		int tensDigit = remainingDigits / 10;
		if (tensDigit == 1) {
			builder.append(TEN_TO_NINETEEN[remainingDigits - 10]);
		} else {
			if (tensDigit > 1) {
				builder.append(TWENTY_TO_NINETY[tensDigit - 2]);
				builder.setSeparator(SPACE);
			}
			convertSingleDigit(remainingDigits % 10);
		}
	}

	private void convertSingleDigit(int singleDigit) {
		if (singleDigit != 0) {
			builder.append(SINGLE_DIGITS[singleDigit - 1]);
		}
	}
}
