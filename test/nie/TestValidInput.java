package nie;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestValidInput {
	@Parameters(name = "{0} -> {1}")
	public static Collection<Object[]> generateParameters() {
		return Arrays.asList(new Object[][] {
			{ "0", "Zero" },
			{ "1", "One" },
			{ "2", "Two" },
			{ "3", "Three" },
			{ "4", "Four" },
			{ "5", "Five" },
			{ "6", "Six" },
			{ "7", "Seven" },
			{ "8", "Eight" },
			{ "9", "Nine" },
			{ "10", "Ten" },
			{ "11", "Eleven" },
			{ "12", "Twelve" },
			{ "13", "Thirteen" },
			{ "14", "Fourteen" },
			{ "15", "Fifteen" },
			{ "16", "Sixteen" },
			{ "17", "Seventeen" },
			{ "18", "Eighteen" },
			{ "19", "Nineteen" },
			{ "20", "Twenty" },
			{ "21", "Twenty one" },
			{ "29", "Twenty nine" },
			{ "30", "Thirty" },
			{ "34", "Thirty four" },
			{ "47", "Fourty seven" },
			{ "56", "Fifty six" },
			{ "100", "One hundred" },
			{ "162", "One hundred and sixty two" },
			{ "200", "Two hundred" },
			{ "205", "Two hundred and five" },
			{ "373", "Three hundred and seventy three" },
			{ "485", "Four hundred and eighty five" },
			{ "598", "Five hundred and ninety eight" },
			{ "1000", "One thousand" },
			{ "1601", "One thousand six hundred and one" },
			{ "2000", "Two thousand" },
			{ "2710", "Two thousand seven hundred and ten" },
			{ "3880", "Three thousand eight hundred and eighty" },
			{ "9999", "Nine thousand nine hundred and ninety nine" },
			{ "10000", "Ten thousand" },
			{ "11600", "Eleven thousand six hundred" },
			{ "12925", "Twelve thousand nine hundred and twenty five" },
			{ "28012", "Twenty eight thousand and twelve" },
			{ "50003", "Fifty thousand and three" },
			{ "100000", "One hundred thousand" },
			{ "300004", "Three hundred thousand and four" },
			{ "433111", "Four hundred and thirty three thousand one hundred and eleven" },
			{ "500024", "Five hundred thousand and twenty four" },
			{ "702000", "Seven hundred and two thousand" },
			{ "873000", "Eight hundred and seventy three thousand" },
			{ "900800", "Nine hundred thousand eight hundred" },
		});
	}

	@Parameter(value = 0)
	public String input;

	@Parameter(value = 1)
	public String expectedOutput;

	@Test
	public void test() {
		String actualOutput = NumberConverter.convertNumberToEnglish(input);
		assertEquals(expectedOutput, actualOutput);
	}
}
