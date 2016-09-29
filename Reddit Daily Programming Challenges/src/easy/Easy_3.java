/*Welcome to cipher day! 
 * write a program that can encrypt texts with an alphabetical caesar cipher. This cipher
 * can ignore numbers, symbols, and whitespace.for extra credit, add a "decrypt" function to your program!
*/




package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Easy_3 {
	private final static int caesar = 3;
	private final static int displacement = 23;
	
	public String encrypt(String toEncrypt){
		char[] tempArray = toEncrypt.toCharArray();
		char[] encryptArray = new char[toEncrypt.toCharArray().length];
		
		for(int i = 0; i < tempArray.length; i++){
			
			if(tempArray[i] >= 65 && tempArray[i] <= 90){
				if(tempArray[i] <= 67){
					encryptArray[i] = (char)(tempArray[i] + displacement);					
				}else{
					encryptArray[i] = (char)(tempArray[i] - caesar);
				}
			
			
			}else if(tempArray[i] >=97 && tempArray[i] <= 122){
				if(tempArray[i] <= 99){
					encryptArray[i] = (char)(tempArray[i] + displacement);
				}else{
					encryptArray[i] = (char)(tempArray[i] - caesar);
				}
			}
		
			
		}
		
		
		return String.valueOf(encryptArray);
	}
	
	public String decrypt(String toDecrypt){
		char[] tempArray = toDecrypt.toCharArray();
		char[] decryptArray = new char[toDecrypt.toCharArray().length];
		
		for(int i = 0; i < tempArray.length; i++){
			
			if(tempArray[i] >=65 && tempArray[i] <= 90){
				if(tempArray[i] >= 88){
					decryptArray[i] = (char)(tempArray[i] - displacement);
				}else{
					decryptArray[i] = (char)(tempArray[i] + caesar);
				}
			
			
			}else if(tempArray[i] >=97 && tempArray[i] <= 122){
				if(tempArray[i] >= 120){
					decryptArray[i] = (char)(tempArray[i] - displacement);
				}else{
					decryptArray[i] = (char)(tempArray[i] + caesar);
				}
			}
		
		}
		
		
		return String.valueOf(decryptArray);
	}
	
	public String getInput(){
		String userInput = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			System.out.println("Enter your text to encrypt:");
			userInput = reader.readLine();
		}catch(IOException e){e.printStackTrace();}
		return userInput;
	}
	public static void main(String[] args){
		String userInput;
		String encrypt;
		String decrypt;
		Easy_3 easy = new Easy_3();
		
		userInput = easy.getInput();
		encrypt = easy.encrypt(userInput);
		decrypt = easy.decrypt(encrypt);
		
		System.out.print("User entered: " + userInput + 
					   "\nThe encryption is: " + encrypt +
					   "\nThe decryption is: " + decrypt);
	}
}
