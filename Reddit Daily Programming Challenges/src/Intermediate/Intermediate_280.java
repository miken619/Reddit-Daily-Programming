/*Description

Anagrams, where you take the letters from one or more words and rearrange them to spell something else, are a fun word game.
In this challenge you'll be asked to create anagrams from specific inputs. You should ignore capitalization as needed, and 
use only English language words. Note that because there are so many possibilities, there are no "right" answers so long as 
they're valid English language words and proper anagrams.

Example Input
First you'll be given an integer on a single line, this tells you how many lines to read. Then you'll be given a word (or words) on N lines to make anagrams for. Example:
1
Field of dreams

Example Output
Your program should emit the original word and one or more anagrams it developed. Example:
Field of dreams -> Dads Offer Lime
Field of dreams -> Deaf Fold Miser

Challenge Input
6
Desperate
Redditor
Dailyprogrammer
Sam likes to swim
The Morse Code
Help, someone stole my purse*/

package Intermediate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Intermediate_280 {

	URI uri = null;
	static List<String> list;
	String[] userInputArray;
	static String result = "";

	Intermediate_280() {
		try {
			uri = this.getClass().getResource("Files/Dictionary.txt").toURI();
			// Comparator<String> byStringLength = (o1,o2) ->
			// Integer.compare(o1.length(), o2.length());
			list = Files.readAllLines(Paths.get(uri)).stream()
					// .sorted(byStringLength)
					.collect(Collectors.toList());

			Collections.shuffle(list);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void processInput() {
		String userInput;
		int numOfLines;

		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter the number of integer");
			userInput = reader.readLine();
			numOfLines = Integer.parseInt(userInput);
			userInputArray = new String[numOfLines];
			System.out.println("Enter your word(s) to change into anagrams");
			for (int i = 0; i < numOfLines; i++) {
				userInput = reader.readLine();
				userInputArray[i] = userInput.toLowerCase();

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public List<String> findAnagramHelper(String word, List<String> findAnagram, String original) {
		List<String> newWord = new ArrayList<>(Arrays.asList(word.toLowerCase().split("")));
		List<String> clone = new ArrayList<>(findAnagram);

		if (word.equals(original))
			return findAnagram;

		for (String s : newWord) {
			if (clone.contains(s))
				clone.remove(s);
			else
				return findAnagram;
		}
		result = result + " " + word;
		return clone;
	}

	public void findAnagram(List<String> findAnagram, String original) {
		List<String> clone = findAnagram;

		int size = findAnagram.size();

		for (String s : list) {

			if (result.replaceAll("\\W", "").trim().length() >= size)
				return;
			clone = findAnagramHelper(s, clone, original);
		}
	}

	public static void main(String[] args) {

		Intermediate_280 mid = new Intermediate_280();
		mid.processInput();
		System.out.println("\n\n\n");
		for (String s : mid.userInputArray) {
			List<String> findAnagram = new ArrayList<>(Arrays.asList(s.replaceAll("\\W", "").split("")));
			mid.findAnagram(findAnagram, s);
			System.out.println(s + " ->" + result);
			result = "";

		}

	}

}
