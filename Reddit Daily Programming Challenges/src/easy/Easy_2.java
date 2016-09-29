/*Hello, coders! An important part of programming is being able to apply your programs, so your challenge for today 
* is to create a calculator application that has use in your life. It might be an interest calculator, or it might be 
* something that you can use in the classroom. For example, if you were in physics class, you might want to make 
* a F = M * A calc.
*
* EXTRA CREDIT: make the calculator have multiple functions! Not only should it be able to calculate F = M * A, 
* but also A = F/M, and M = F/A!
*/



package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Easy_2 {
	
	
	public void calculateForce(double operand1, double operand2){
		System.out.println("Force = " + (operand1 * operand2));
	}
	
	public void calculateAcceleration(double operand1, double operand2){
		System.out.println("Acceleration = " + (operand1/operand2));
	}
	
	public void calculateMass(double operand1, double operand2){
		System.out.println("Mass = " + (operand1/operand2));
	}
	
	public void determineCal(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int userInput = 0;
		double operand1 = 0;
		double operand2 = 0;
		
		try{
			System.out.print("Which calculation would you like to do\n" +
		                     "1. Force\n" +
					         "2. Acceleration\n" +
		                     "3. Mass\n\n");
			userInput = Integer.parseInt(reader.readLine());
			
			
			switch(userInput){
			case 1:
				System.out.print("Enter the mass ");
				operand1 = Double.parseDouble(reader.readLine());
				System.out.print("Enter the acceleration ");
				operand2 = Double.parseDouble(reader.readLine());
				calculateForce(operand1, operand2);
				break;
			case 2:
				System.out.print("Enter the force ");
				operand1 = Double.parseDouble(reader.readLine());
				System.out.print("Enter the mass ");
				operand2 = Double.parseDouble(reader.readLine());
				calculateAcceleration(operand1,operand2);
				break;
			case 3:
				System.out.print("Enter the force ");
				operand1 = Double.parseDouble(reader.readLine());
				System.out.print("Enter the acceleration ");
				operand2 = Double.parseDouble(reader.readLine());
				calculateMass(operand1,operand2);
				break;
			default:
				System.out.println("invalid input, system will now exits");
				System.exit(1);
			}
		}catch(IOException e){e.printStackTrace();}
		
		
	}

	public static void main(String[] args) {
		Easy_2 easy = new Easy_2();
		
		easy.determineCal();

	}

}
