/*Description:

Text reflow means to break up lines of text so that they fit within a certain width.
 It is useful in e.g. mobile browsers. When you zoom in on a web page the lines will
  become too long to fit the width of the screen, unless the text is broken up into 
  shorter lines.

Input:

You will be given a text with a maximum line width of 80 characters.
Output:

Produce the same text with a maximum line width of 40 characters
Challenge Input:

In the beginning God created the heavens and the earth. Now the earth was 
formless and empty, darkness was over the surface of the deep, and the Spirit of
God was hovering over the waters.

And God said, "Let there be light," and there was light. God saw that the light
was good, and he separated the light from the darkness. God called the light
"day," and the darkness he called "night." And there was evening, and there was
morning - the first day.

Challenge Output:

In the beginning God created the heavens
and the earth. Now the earth was
formless and empty, darkness was over
the surface of the deep, and the Spirit
of God was hovering over the waters.

And God said, "Let there be light," and
there was light. God saw that the light
was good, and he separated the light
from the darkness. God called the light
"day," and the darkness he called
"night." And there was evening, and
there was morning - the first day.
Bonus:

Let's get rid of the jagged right margin of the text and make the output prettier. Output the 
text with full justification; Adjusting the word spacing so that the text is flush against both 
the left and the right margin.
Bonus Output:

In the beginning God created the heavens
and   the  earth.   Now  the  earth  was
formless  and empty,  darkness was  over
the  surface of the deep, and the Spirit
of  God was  hovering over  the  waters.

And  God said, "Let there be light," and
there  was light. God saw that the light
was  good, and  he separated  the  light
from  the darkness. God called the light
"day,"   and  the   darkness  he  called
"night."  And  there  was  evening,  and
there  was  morning  -  the  first  day.
Finally*/

package Intermediate;

import java.util.ArrayList;

public class Intermediate_279 {
	private static final int MAX_LINE_WIDTH = 40;
	private static final String TEXT = "In the beginning God created the heavens and the earth. Now the earth was \n"
			+ "formless and empty, darkness was over the surface of the deep, and the Spirit of \n"
			+ "God was hovering over the waters. \n\n"

			+ "And God said, \"Let there be light,\" and there was light. God saw that the light \n"
			+ "was good, and he separated the light from the darkness. God called the light \n"
			+ "day,\" and the darkness he called \"night.\" And there was evening, and there was \n"
			+ "morning - the first day.";
	
	static int MAX_LINE = 0;
	
	
	public void output() {
		ArrayList<String> list = findOutput();
		for(String s: list)
			System.out.println(s);

	}

	public void prettyOutput() {
		ArrayList<String> list = findOutput();
		String result = null;
		for(String s: list){
			if(s.length() != MAX_LINE)
				result = findPrettyString(s);			
			else
				result = s;
			
			System.out.println(result);
		}
	}
	
	public String findPrettyString(String s){
		String[] array = s.split(" ");
		int arrayLength = array.length;
		int stringLength = s.length();
		int difference = MAX_LINE - stringLength;
		StringBuilder sb = null;
		
		for(int i = 0; i < arrayLength || difference != 0; i++){
			if(i == 0){
				sb = new StringBuilder();
				
			}
			if(i == arrayLength){
				i = -1;
				continue;
			}
			
			
			if(i < difference)
				sb.append(array[i] + "  ");
			else
				sb.append(array[i] + " ");
			
			
			
			stringLength = sb.toString().length();
			difference = MAX_LINE - stringLength;
		}
		
		
		
		
		return sb.toString();
	}
	
	public ArrayList<String> findOutput(){
		String result = "";
		String[] textArray = TEXT.split("\\s");
		ArrayList<String> list = new ArrayList<>();
		int lineLength = 0;

		for (String string : textArray) {

			lineLength = (result + " " + string).trim().length();

			if (lineLength > MAX_LINE_WIDTH) {
				list.add(result);
				lineLength = result.length();
				result = string;
				MAX_LINE = Math.max(MAX_LINE,lineLength);
			} else {
				result += " " + string;
			}

			result = result.trim();
		}

		list.add(result);
		return list;
		
	}

	public static void main(String[] args) {
		Intermediate_279 inter = new Intermediate_279();
		//inter.output();
		
		inter.prettyOutput();

	}

}
