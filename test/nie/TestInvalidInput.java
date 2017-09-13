package nie;

import static nie.errors.ErrorMessage.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import nie.errors.ErrorMessage;
import nie.errors.NumbersInEnglishException;

@RunWith(Parameterized.class)
public class TestInvalidInput {
	@Parameters(name = "{0} -> {1}")
	public static Collection<Object[]> generateParameters() {
		return Arrays.asList(new Object[][] {
			{ "", NoInputProvided },
			{ null, NoInputProvided },
			{ "Text", NonIntegerInput },
			{ "NaN", NonIntegerInput },
			{ "123x", NonIntegerInput },
			{ "null", NonIntegerInput },
			{ "1.23", NonIntegerInput },
			{ ".1", NonIntegerInput },
			{ "2-1", NonIntegerInput },
			{ "1234567890123456789012345678901234", OutOfRange },
			{ "-1234567890123456789012345678901234", OutOfRange },
		});
	}

	@Parameter(value = 0)
	public String input;

	@Parameter(value = 1)
	public ErrorMessage expectedErrorMessage;

	@Test
	public void convertNumberToEnglishShouldThrowExpectedException() {
		try {
			new NumberConverter(input).convertNumberToEnglish();
			fail("No exception was thrown");
		} catch (NumbersInEnglishException e) {
			assertEquals(expectedErrorMessage.toString(), e.getMessage());
		}
	}
}
