/*Description

Their are some false golden coins, wich are lighter then others, in the treasure chest. The assistant has weighed the coins, but can not figure out which are false and which are not.
Formal Inputs & Outputs

Input description

Each coin is labeled with a letter, and is put on the scale in groups or by itself. The input consist of the coins on the left side, the coins on the right side and the way the scale tipped. This can be left, right or equal when the two sides wheigt the same.

Input 1

a b left
a c equal

Input 2

a c equal

Input 3

a c equal
a b equal
c b left

Output description

You must determine which coins are lighter then the others.

Output 1

b is lighter
It is possible that you can't determine this because you have not in enough info.

Output 2

no fake coins detected
And it is possible that the provided data has been inconsistent.

Output 3

data is inconsistent
Notes/Hints

left means that the left side is heavier. Same goes for right...

Challenge input

1

ab xy left
b x equal
a b equal

2

a x equal
b x equal
y a left

3

abcd efgh equal
abci efjk left
abij efgl equal
mnopqrs tuvwxyz equal

4

abc efg equal
a e left

Finally

Have a good challenge idea?
Consider submitting it to /r/dailyprogrammer_ideas
Edit Notes

You can assume that there is only 1 fake coin, if not, the data is inconsistent. If your solution worked without this assumption, you can leave it like that.
And all real coins weight the same, just like the fake coins. But no real weight is necessary to complete the challenge
*/

package Intermediate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Intermediate_277 {
	ArrayList<Structure> list = new ArrayList<>();
	private static final String IS_LIGHTER = " is lighter";
	private static final String NO_FAKE_COINS_DETECTED = "no fake coins detected";
	private static final String DATA_IS_INCONSISTENT = "data is inconsistent";
	private static final String LEFT = "left";
	private static final String RIGHT = "right";
	private static final String EQUAL = "equal";

	class Structure {
		String leftCoin = "";
		String rightCoin = "";
		String relationship = "";

		Structure(String operand1, String operand2, String operand3) {
			if (operand3.equals(RIGHT)) {
				leftCoin = operand2;
				rightCoin = operand1;
				relationship = LEFT;
			} else if (operand3.equals(LEFT) || operand3.equals(EQUAL)) {
				leftCoin = operand1;
				rightCoin = operand2;
				relationship = operand3;
			}

		}

	}

	public void getInput() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		String[] inputArray;
		try {
			do {
				input = reader.readLine().trim();

				if (!input.equals("")) {

					inputArray = input.split(" ");
					list.add(new Structure(inputArray[0], inputArray[1], inputArray[2]));
				}
			} while (!input.equals(""));

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void findFakeCoin() {
		List<String> heavyCoin = null;
		List<String> lightCoin = null;
		String results = NO_FAKE_COINS_DETECTED;
		List<String> equal = new ArrayList<>();

		for (Structure s : list) {

			if (s.relationship.equals(EQUAL)) {
				if (equal.contains(s.leftCoin))
					equal.add(s.rightCoin);
				else if (equal.contains(s.rightCoin))
					equal.add(s.leftCoin);
				else {
					equal.add(s.leftCoin);
					equal.add(s.rightCoin);
				}
			} else {
				heavyCoin = new LinkedList<>(Arrays.asList(s.leftCoin.split("")));
				lightCoin = new LinkedList<>(Arrays.asList(s.rightCoin.split("")));
			}

		}

		if (heavyCoin == null && lightCoin == null) {
			System.out.println(results);
			return;
		}

		for (String s : equal) {

			if (heavyCoin.contains(s))
				heavyCoin.remove(s);

			if (lightCoin.contains(s))
				lightCoin.remove(s);

			if (!lightCoin.isEmpty())
				results = lightCoin.get(0) + IS_LIGHTER;
			else
				results = DATA_IS_INCONSISTENT;
		}

		System.out.println(results);

	}

	public static void main(String[] args) {
		Intermediate_277 mid = new Intermediate_277();
		mid.getInput();
		mid.findFakeCoin();

	}

}
