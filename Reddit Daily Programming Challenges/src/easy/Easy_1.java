package easy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * create a program that will ask the users name, age, and reddit username. have it tell them the information back, in the format:
 * your name is (blank), you are (blank) years old, and your username is (blank)
 * for extra credit, have the program log this information in a file to be accessed later.
 */
public class Easy_1 {
	
	public String[] getInput(){
		String[] _output =  new String[3];
		String _userInput;
		String[] _questionList = {"your name is",
				                  "you're years old",
				                  "and your username is"};
		BufferedReader _read = new BufferedReader(new InputStreamReader(System.in));
		
		
		try{
			for(int i = 0; i < _questionList.length; i++){
				System.out.print(_questionList[i] + " ");
				_userInput = _read.readLine();
				
				if(_questionList[i].contains("years")){
					_output[i] = _questionList[i].substring(0,_questionList[i].indexOf(" ")) 
							     + " " + _userInput + _questionList[i].substring(_questionList[i].indexOf(" years"),_questionList[i].length()) ; 
				}else{
					_output[i] = _questionList[i] + " " + _userInput;
				}
				
			}
		}catch(IOException e){e.printStackTrace();}
		return _output;
	}
	
	public void printOutput(String[] output){
		for(String string: output){
			System.out.println(string);
		}
	}
	
	public static void main(String[] args){
		String[] _output;
		Easy_1 easy_1 = new Easy_1();
		_output = easy_1.getInput();
		easy_1.printOutput(_output);
	}

}
