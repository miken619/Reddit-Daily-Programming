/*The key function is a higher order array function modelled in sql as group by and in J as /. For each key, apply a passed function to the entire subarray of items that share the same key.
function signature

key(
 elements:  an array/list of stuff. number of items is leading array dimension,
 key: an array/list of stuff.  Same amount of items as "elements".  If null, then defaults to same array as elements,
 applyfunction:  function that will be called for each group of elements that have the same key.  Optionally, this function could also have the key parameter.  Results are aggregated in order of key appearance.
 )
key(3 4 5 6 , 2 0 1 2 , sum)
would produce
9 4 5
There are 2 elements with key 2, and so for key 2, sum is called with 3 6. Results accumulated in order of key seen.
1. Histogram

for each item in input, return a record with the key and the item count for that key
input:
 5 3 5 2 2 9 7 0 7 5 9 2 9 1 9 9 6 6 8 5 1 1 4 8 5 0 3 5 8 2 3 8 3 4 6 4 9 3 4 3 4 5 9 9 9 7 7 1 9 3 4 6 6 8 8 0 4 0 6 3 2 6 3 2 3 5 7 4 2 6 7 3 9 5 7 8 9 5 6 5 6 8 3 1 8 4 6 5 6 4 8 9 5 7 8 4 4 9 2 6 10
output
 5 13
 3 12
 2  8
 9 14
 7  8
 0  4
 1  5
 6 13
 8 11
 4 12
10  1
2. grouped sum of field

for each record use the first field as key, and return key and sum of field 2 (grouped by key)
input:
a 14
b 21
c 82
d 85
a 54
b 96
c 9 
d 61
a 43
b 49
c 16
d 34
a 73
b 59
c 36
d 24
a 45
b 89
c 77
d 68
output:
┌─┬───┐
│a│229│
├─┼───┤
│b│314│
├─┼───┤
│c│220│
├─┼───┤
│d│272│
└─┴───┘
3. nub (easier)

the "nub of an array" can be implemented with key. It is similar to sql first function.
for the input from 2. return the first element keyed (grouped) by first column
output:
  (>@{."1 ({./.) ]) b
┌─┬──┐
│a│14│
├─┼──┤
│b│21│
├─┼──┤
│c│82│
├─┼──┤
│d│85│
└─┴──┘
note

I will upvote if you write a key function that functionally returns an array/list. (spirit of challenge is not to shortcut through actual data inputs)




I'm not OP, but let me explain it.
As far as I understand, this challenge #276 has 3 mini-challenges:
#276-1: Histogram.
#276-2: Grouped sum of field
#276-3: Nub (easier)
The soul of this challenge is to solve all of these mini-challenges using the signature function: key(elements, keys, applyFunction)
But, how does the key function works???
We have the following example:
key(3 4 5 6 , 2 0 1 2 , sum) would produce 9 4 5
The "keys" parameter (second one) has to have the same amount of items as the "elements" parameter (first one) because you'll map each element with a key, such as:
3 4 5 6 (elements)
| | | |
2 0 1 2 (keys)
So, in this example and after the mapping process:
What elements have a "2" as key: 3 and 6.
What elements have a "1" as key: 5.
What elements have a "0" as key: 4.
Now that you have mapped each element with a key, you apply the fuction to the elements with the same key. Remember: "Results are aggregated in order of key appearance."
Producing the answer of this example:
Sum of elements with key "2" = sum of "3" and "6" = 9
Sum of elements with key "1" = sum of 4 = 4
Sum of elements with key "0" = sum of 5 = 5
Sum of elements with key "2" = already done = don't aggregate to return answer
So, that's why the returned answer is 9 4 5.

*/

package Intermediate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Intermediate_276 {

	public void calHistogram(String items) {
		String[] itemArray = items.split(" ");
		HashMap<String, Integer> map = new HashMap<>();

		for (String s : itemArray) {
			if (map.containsKey(s))
				map.replace(s, map.get(s) + 1);
			else
				map.put(s, 1);
		}

		map.forEach((e1, e2) -> System.out.println(e1 + " = " + e2));
	}

	public void calSumOfField(String items) {
		String[] itemArray = items.split(System.getProperty("line.separator"));
		HashMap<String, Integer> map = new HashMap<>();

		for (String s : itemArray) {
			String[] sArray = s.split(" ");
			String key = sArray[0];
			int value = Integer.parseInt(sArray[1]);

			if (map.containsKey(key))
				map.replace(key, map.get(key) + value);
			else
				map.put(key, value);
		}

		map.forEach((e1, e2) -> System.out.println(e1 + " = " + e2));
	}

	public void calNub(String items) {
		String[] itemArray = items.split(System.getProperty("line.separator"));
		HashMap<String, Integer> map = new HashMap<>();

		for (String s : itemArray) {
			String[] sArray = s.split(" ");
			String key = sArray[0];
			int value = Integer.parseInt(sArray[1]);

			if (!map.containsKey(key))
				map.put(key, value);
		}

		map.forEach((e1, e2) -> System.out.println(e1 + " = " + e2));

	}

	private void getInput() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String option = "";
		String input = "";
		String questionToAsk = "";

		try {
			System.out.println("Select an option\n" + "1. Histogram\n" + "2. Sum of field\n" + "3. Nub\n");

			option = reader.readLine().trim();

			System.out.println("Enter your values and press enter once again when finish");
			do {
				sb.append(input = reader.readLine().trim());
				sb.append(System.getProperty("line.separator"));
			} while (!input.toString().equals(""));

			input = sb.toString();
			switch (option) {
			case "1":
				calHistogram(input);
				break;
			case "2":
				calSumOfField(input);
				break;
			case "3":
				calNub(input);
				break;
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Intermediate_276 mid = new Intermediate_276();
		mid.getInput();
	}

}
