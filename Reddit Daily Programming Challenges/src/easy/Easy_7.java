/* Write a program that can translate Morse code in the format of ...---...
 * A space and a slash will be placed between words. ..- / --.-
 * For bonus, add the capability of going from a string to Morse code.
 * Super-bonus if your program can flash or beep the Morse.
 * This is your Morse to translate:
 * .... . .-.. .-.. --- / -.. .- .. .-.. -.-- / .--. .-. --- --. .-. .- -- -- . .-. / --. --- --- -.. / .-.. ..- -.-. -.- / --- -. / - .... . / -.-. .... .- .-.. .-.. . -. --. . ... / - --- -.. .- -.--





*/




package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Easy_7 {
	static HashMap<String,String> morseCode ;
	static HashMap<String,String> reverseMorseCode;
	
	static{
		morseCode = new HashMap<>();
		reverseMorseCode = new HashMap<>();
		
		morseCode.put("a",".-");morseCode.put("b","-...");
		morseCode.put("c","-.-.");morseCode.put("d","-..");
		morseCode.put("e",".");morseCode.put("f","..-.");
		morseCode.put("g","--.");morseCode.put("h","....");
		morseCode.put("i","..");morseCode.put("j",".---");
		morseCode.put("k","-.-");morseCode.put("l",".-..");
		morseCode.put("m","--");morseCode.put("n","-.");
		morseCode.put("o","---");morseCode.put("p",".--.");
		morseCode.put("q","--.-");morseCode.put("r",".-.");
		morseCode.put("s","...");morseCode.put("t","-");
		morseCode.put("u","..-");morseCode.put("v","...-");
		morseCode.put("w",".--");morseCode.put("x","-..-");	
		morseCode.put("y","-.--");morseCode.put("z","--..");
		morseCode.put(" ","/");
		
		for(Map.Entry<String,String> map: morseCode.entrySet())
			reverseMorseCode.put(map.getValue(),map.getKey());
		
		
	}
	
	
	public String getInput(){
		String input = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			System.out.println("Enter your morse code: ");
			input = reader.readLine();
		}catch(IOException e){e.printStackTrace();}
		
		return input;
	}
	
	public String decipherMorseCode(String input){
		String[] codeArray = input.split(" ");
		StringBuilder sb = new StringBuilder();
	
		for(String code: codeArray){
			
			sb.append(reverseMorseCode.get(code));
		}
		
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		Easy_7 easy = new Easy_7();
		String input;
		String result;
		
		input = easy.getInput();
		result = easy.decipherMorseCode(input);
		
		System.out.println(result);
		
	}

}
