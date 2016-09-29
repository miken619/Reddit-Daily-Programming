/* Your challenge for today is to create a program which is password protected, and wont open unless the correct
 * user and password is given. For extra credit, have the user and password in a seperate .txt file.
 * for even more extra credit, break into your own program :)
 */




package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Easy_5 {
	private static final String PASSWORD = "password";
	private static final String USER= "user";
	private String inputedPassword = null;
	private String inputedUsername = null;
	private BufferedReader reader = null;
	
	
	public String getInputedPassword() {
		return inputedPassword;
	}

	public void setInputedPassword(String inputedPassword) {
		this.inputedPassword = inputedPassword;
	}

	public String getInputedUsername() {
		return inputedUsername;
	}

	public void setInputedUsername(String inputedUsername) {
		this.inputedUsername = inputedUsername;
	}
	
	
	
	public void checkInfo(){
		String user;
		String password;
		while(true){
			user = getInputedUsername();
			password = getInputedPassword();
			
			if(!user.equals(USER) && !password.equals(PASSWORD)){
				System.out.println("Incorrect credentials, try again");
				getInput();
			}else{
				System.out.println("You entered the correct username and password");
				break;
			}
		}
		
		try{
		reader.close();
		}catch(IOException e){}
	}
	
	public void getInput(){
		String input;
		reader = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			System.out.print("Enter your username: ");
			input = reader.readLine().trim();
			setInputedUsername(input);
			
			System.out.print("Enter your password: ");
			input = reader.readLine().trim();
			setInputedPassword(input);
		}catch(IOException e){e.printStackTrace();}
		
	}
	public static void main(String[] args) {
		Easy_5 easy = new Easy_5();
		
		easy.getInput();
		easy.checkInfo();

	}

}
