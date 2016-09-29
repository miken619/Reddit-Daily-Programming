/*Description:

Due to an unfortunate compression error your lucky number in base n was compressed to a simple string where the conversion to decimal has potentially many values.
Normal base n numbers are strings of characters, where each character represents a value from 0 to (n-1) inclusive. The numbers we are dealing with here can only use digits though, so some "digits" span multiple characters, causing ambiguity.
For example "A1" in normal hexadecimal would in our case be "101" as "A" converts to 10, as "A" is the 10th character in base 16
"101" is can have multiple results when you convert from ambiguous base 16 to decimal as it could take on the possible values:
 1*16^2 + 0*16^1 + 1*16^0  (dividing the digits as [1][0][1])
 10*16^1 + 1*16^0 (dividing the digits as [10][1])
A few notes:
Digits in an "ambiguous" number won't start with a 0. For example, dividing the digits in 101 as [1][01] is not valid because 01 is not a valid digit.
Ensure that your solutions work with non-ambiguous bases, like "1010" base 2 -> 10
Recall that like normal base n numbers the range of values to multiply by a power of n is 0 to (n-1) inclusive.

Input:
You will be given a string of decimal values ("0123456789") and a base n.

Output:
Convert the input string to all possible unique base 10 values it could take on, sorted from smallest to largest.

Challenge Inputs
101 2
101 16
120973 25

Bonus Inputs
25190239128039083901283 100
251902391280395901283 2398
The first 10,000 values of each Bonus output are pasted here respectively:
http://pastebin.com/QjP3gazp
http://pastebin.com/ajr9bN8q

Finally
Credit for this challenge goes to by /u/wwillsey, who proposed it in /r/dailyprogrammer_ideas. Have your own neat challenge idea? Drop by and show it off!

*/

package Intermediate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Intermediate_255 {
	private static ArrayList<BigInteger> resultList = new ArrayList<>();
	private static ArrayList<BigInteger> val = new ArrayList<>();
	private static BigInteger base;

	public void calculateLuckyNum(BigInteger result, int index, int length) {
		BigInteger num = BigInteger.ZERO;

		if (!(index < val.size())) {

			resultList.add(result);
			return;
		}

		if (val.get(index).equals(BigInteger.ZERO)) {
			calculateLuckyNum(result, ++index, --length);

		} else {
			while (index < val.size()) {
				num = num.multiply(BigInteger.TEN).add(val.get(index));

				if (num.compareTo(base) >= 0)
					break;
				// System.out.println(num);
				calculateLuckyNum(base.pow(length).multiply(num).add(result), ++index, --length);

			}
		}
	}

	public void getInput() {
		String[] userInput = null;
		String parseValue = null;
		String[] value = null;
		int length;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.print("Enter your numbers and base: ");
			userInput = reader.readLine().split(" ");
			parseValue = userInput[0];
			value = parseValue.split("");
			base = new BigInteger(userInput[1]);

		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < value.length; i++) {

			val.add(new BigInteger(value[i]));

		}

		length = val.size() - 1;

		calculateLuckyNum(BigInteger.ZERO, 0, length);
	}

	public static void main(String[] args) {
		Intermediate_255 mid = new Intermediate_255();

		mid.getInput();
		
		Collections.sort(resultList);
		
		for (BigInteger value : resultList) {
			System.out.println(value);
		}

	}

}
