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
			{ "1000000", "One million" },
			{ "2400000", "Two million four hundred thousand" },
			{ "3510000", "Three million five hundred and ten thousand" },
			{ "4901000", "Four million nine hundred and one thousand" },
			{ "5800300", "Five million eight hundred thousand three hundred" },
			{ "6012001", "Six million twelve thousand and one" },
			{ "7000209", "Seven million two hundred and nine" },
			{ "10000000", "Ten million" },
			{ "25000102", "Twenty five million one hundred and two" },
			{ "40200000", "Fourty million two hundred thousand" },
			{ "60001009", "Sixty million one thousand and nine" },
			{ "87528433", "Eighty seven million five hundred and twenty eight thousand four hundred and thirty three" },
			{ "100000000", "One hundred million" },
			{ "300000006", "Three hundred million and six" },
			{ "501000900", "Five hundred and one million nine hundred" },
			{ "712501020", "Seven hundred and twelve million five hundred and one thousand and twenty" },
			{ "999999999", "Nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" },
			{ "1000000000", "One billion" },
			{ "12000049002", "Twelve billion fourty nine thousand and two" },
			{ "508017032166", "Five hundred and eight billion seventeen million thirty two thousand one hundred and sixty six" },
			{ "999999999999",
				"Nine hundred and ninety nine billion nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" },
			{ "999999999999999",
				"Nine hundred and ninety nine trillion nine hundred and ninety nine billion nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" },
			{ "999999999999999999",
				"Nine hundred and ninety nine quadrillion nine hundred and ninety nine trillion nine hundred and ninety nine billion nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" },
			{ "999999999999999999999",
				"Nine hundred and ninety nine quintillion nine hundred and ninety nine quadrillion nine hundred and ninety nine trillion nine hundred and ninety nine billion nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" },
			{ "999999999999999999999999",
				"Nine hundred and ninety nine sextillion nine hundred and ninety nine quintillion nine hundred and ninety nine quadrillion nine hundred and ninety nine trillion nine hundred and ninety nine billion nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" },
			{ "999999999999999999999999999",
				"Nine hundred and ninety nine septillion nine hundred and ninety nine sextillion nine hundred and ninety nine quintillion nine hundred and ninety nine quadrillion nine hundred and ninety nine trillion nine hundred and ninety nine billion nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" },
			{ "999999999999999999999999999999",
				"Nine hundred and ninety nine octillion nine hundred and ninety nine septillion nine hundred and ninety nine sextillion nine hundred and ninety nine quintillion nine hundred and ninety nine quadrillion nine hundred and ninety nine trillion nine hundred and ninety nine billion nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" },
			{ "999999999999999999999999999999999",
				"Nine hundred and ninety nine nonillion nine hundred and ninety nine octillion nine hundred and ninety nine septillion nine hundred and ninety nine sextillion nine hundred and ninety nine quintillion nine hundred and ninety nine quadrillion nine hundred and ninety nine trillion nine hundred and ninety nine billion nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" },
			{ "-1", "Minus one" },
			{ "-63", "Minus sixty three" },
			{ "-312", "Minus three hundred and twelve" },
			{ "-76002", "Minus seventy six thousand and two" },
			{ "-59101948", "Minus fifty nine million one hundred and one thousand nine hundred and fourty eight" },
			{ "-234000000003", "Minus two hundred and thirty four billion and three" },
			{ "-11006827032071", "Minus eleven trillion six billion eight hundred and twenty seven million thirty two thousand and seventy one" },
			{ "-999999999999999999",
				"Minus nine hundred and ninety nine quadrillion nine hundred and ninety nine trillion nine hundred and ninety nine billion nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" },
			{ "-999999999999999999999",
				"Minus nine hundred and ninety nine quintillion nine hundred and ninety nine quadrillion nine hundred and ninety nine trillion nine hundred and ninety nine billion nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" },
			{ "-999999999999999999999999",
				"Minus nine hundred and ninety nine sextillion nine hundred and ninety nine quintillion nine hundred and ninety nine quadrillion nine hundred and ninety nine trillion nine hundred and ninety nine billion nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" },
			{ "-999999999999999999999999999",
				"Minus nine hundred and ninety nine septillion nine hundred and ninety nine sextillion nine hundred and ninety nine quintillion nine hundred and ninety nine quadrillion nine hundred and ninety nine trillion nine hundred and ninety nine billion nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" },
			{ "-999999999999999999999999999999",
				"Minus nine hundred and ninety nine octillion nine hundred and ninety nine septillion nine hundred and ninety nine sextillion nine hundred and ninety nine quintillion nine hundred and ninety nine quadrillion nine hundred and ninety nine trillion nine hundred and ninety nine billion nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" },
			{ "-999999999999999999999999999999999",
				"Minus nine hundred and ninety nine nonillion nine hundred and ninety nine octillion nine hundred and ninety nine septillion nine hundred and ninety nine sextillion nine hundred and ninety nine quintillion nine hundred and ninety nine quadrillion nine hundred and ninety nine trillion nine hundred and ninety nine billion nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine" },
			{ "-0", "Zero" }
		});
	}

	@Parameter(value = 0)
	public String input;

	@Parameter(value = 1)
	public String expectedOutput;

	@Test
	public void convertNumberToEnglishShouldReturnExpectedOutput() throws Exception {
		String actualOutput = new NumberConverter(input).convertNumberToEnglish();
		assertEquals(expectedOutput, actualOutput);
	}
}
