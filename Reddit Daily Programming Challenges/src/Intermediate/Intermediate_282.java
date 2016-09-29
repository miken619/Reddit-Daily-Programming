package Intermediate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Intermediate_282 {
	private static final int GRIDSIZE = 5;
	private static final String NO_WINNING_MOVES = "no winning moves";

	class Tiles {
		Tiles left;
		Tiles right;
		Tiles up;
		Tiles down;
		char symbol;
		String position;

		Tiles(Tiles left, Tiles right, Tiles up, Tiles down, char symbol, String position) {
			super();
			this.left = left;
			this.right = right;
			this.up = up;
			this.down = down;
			this.symbol = symbol;
			this.position = position;
		}
	}

	public Tiles setUp() {
		Tiles prevHead = null;
		Tiles down = null;
		Tiles prevTail = null;
		Tiles pointer = null;
		ArrayList<Tiles> tileList = null;

		String input = getInput();
		String[] inputArray = input.split("\\n");
		char symbol;

		for (int i = 0; i < GRIDSIZE; i++) {
			symbol = inputArray[i].charAt(0);
			char val = 'A';
			String position = "" + val + (i + 1);
			Tiles head = new Tiles(null, null, prevHead, null, symbol, position);
			prevTail = head;
			if (prevHead != null) {
				prevHead.down = prevTail;
				prevHead = prevHead.right;
			}
			if (i == 0)
				pointer = head;
			for (int j = 1; j < GRIDSIZE; j++) {

				symbol = inputArray[i].charAt(j);
				position = "" + (char) (val + j) + (i + 1);
				Tiles tail = new Tiles(prevTail, null, prevHead, null, symbol, position);

				prevTail.right = tail;
				prevTail = prevTail.right;
				if (prevHead != null) {
					prevHead.down = prevTail;
					prevHead = prevHead.right;
				}

			}
			prevHead = head;

		}
		return pointer;
	}

	public String getInput() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = "";

		try {
			System.out.println("Enter your values and press enter when done");
			do {
				sb.append(input = reader.readLine());
				sb.append(System.getProperty("line.separator"));

			} while (!input.equals(""));
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();
	}

	public void findHorizontalWinningMove(Tiles head) {
		Tiles down = head;
		Tiles right = null;
		String position = null;
		
		while(down != null){
			right = down;
			while(right != null){
				if(right.symbol == 'o')
					break;
				
				if(right.symbol == '_'){
					position = right.position + " -> ";
					
				}
						
					
				}
				
			}
			
			
			
			
	}
		
	public void findAllEndPosition(String position){
		String[] array = position.split("");
		String letter = array[0];
		int number = Integer.parseInt(array[1]);
		
		if()
	}
	
		
		
	
	

	public static void main(String[] args) {
		Intermediate_282 mid = new Intermediate_282();
		Tiles head = mid.setUp();
		mid.findHorizontalWinningMove(head);

	}

}
