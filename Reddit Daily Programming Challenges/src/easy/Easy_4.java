/*You're challenge for today is to create a random password generator!
 * For extra credit, allow the user to specify the amount of passwords to generate.
 * For even more extra credit, allow the user to specify the length of the strings he wants to generate!*/





package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Random;

public class Easy_4 {
	private final static String AMOUNT = "AMOUNT";
	private final static String LENGTH = "LENGTH";
	
	
	private static final char[] templete;
	
	static{
		StringBuilder sb = new StringBuilder();
		
		for(char i = '0'; i <='9';i++){
			sb.append(i);
		}
		for(char j = 'a'; j <='z';j++){
			sb.append(j);
		}
		for(char z = 'A'; z <='Z';z++){
			sb.append(z);
		}
		
		templete = sb.toString().toCharArray();
	}

	public String generatePasswords(HashMap<String,Integer> input){
		StringBuilder generatedPasswords = new StringBuilder();
		int amount = input.get(AMOUNT);
		int length = input.get(LENGTH);
		Random random = new Random();
	
		
		for(int i = 0; i < amount; i++){
			for(int j = 0; j < length; j++){
				generatedPasswords.append(templete[random.nextInt(templete.length)]);
			}
			generatedPasswords.append("\n");
		}
		
		return generatedPasswords.toString();
	
	
	
	}
	
	
	
	
	/*public String generatePasswords(HashMap<String,Integer> input){
		StringBuilder generatedPasswords = new StringBuilder();
		int amount = input.get(AMOUNT);
		int length = input.get(LENGTH)* 5;
		SecureRandom random = new SecureRandom();
		
		for(int i = 0; i < amount; i++){
			generatedPasswords.append(new BigInteger(length, random).toString(32) + "\n");
			
		}
		
		return generatedPasswords.toString();
	}*/
	public HashMap<String,Integer>  getInput(){
		HashMap<String,Integer> input = new HashMap<>();
		int parseInt;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			System.out.println("Enter the amount of passwords you would like to generate");
			parseInt = Integer.parseInt(reader.readLine().trim());
			input.put(AMOUNT, parseInt);
			System.out.println("Enter length of the password");
			parseInt = Integer.parseInt(reader.readLine().trim());
			input.put(LENGTH, parseInt);
		}catch(IOException | NumberFormatException e){e.printStackTrace();}
		
		return input;
	
	}
	
	public static void main(String[] args) {
		Easy_4 easy = new Easy_4();
		HashMap<String,Integer> input;
		String generatedPasswords;
		
		input = easy.getInput();
		generatedPasswords = easy.generatePasswords(input);
		
		System.out.println(generatedPasswords);
	}

}
