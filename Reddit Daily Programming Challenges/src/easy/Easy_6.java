/* You're challenge for today is to create a program that can calculate pi accurately to at least 30 decimal places.
 * Try not to cheat :)*/




package easy;

import java.math.BigDecimal;
import java.math.MathContext;

public class Easy_6 {
	
	private static final int CONSTANT4 = 4;
	

	
	
	
	public String calculatePI(){
		MathContext mc = new MathContext(35);	
		BigDecimal numerator = new BigDecimal(CONSTANT4,mc);
		BigDecimal denumerator;
		BigDecimal next;
		BigDecimal result = new BigDecimal(0,mc);
		
		
		boolean add = true;
		int length = 2000000;

		for(int i = 1; i < length; i +=2){			
			
			denumerator = new BigDecimal(i,mc);
			next = numerator.divide(denumerator,mc);
			
			if(add == true){
				result = result.add(next);				
			}else
				result = result.subtract(next);
			
			add = !add;
			
		}
		
		

		result = result.setScale(30, BigDecimal.ROUND_HALF_UP);
		return result.toString();
	}
	
	public static void main(String[] args) {
		String result;
		Easy_6 easy = new Easy_6();
		
		result = easy.calculatePI();
		
		System.out.println(result);

	}

}
