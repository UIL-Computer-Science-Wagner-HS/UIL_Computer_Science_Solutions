import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Rishi {
	
	public static void encode(String input) {
		int frequency = 1;
		char currentChar = input.charAt(0);
		for(int i = 1; i<input.length(); i++) {
			if(input.charAt(i)==currentChar) {
				frequency++;
			} else {
				System.out.print(frequency+""+currentChar);
				frequency = 1;
				currentChar = input.charAt(i);
			}
		}
		System.out.println(frequency+""+currentChar);
	}
	
	public static void decode(String input) {
		String numberString = "";
		for(int i = 0;i<input.length(); i++) {
			char nextChar = input.charAt(i);
			if(Character.isDigit(nextChar)) {
				numberString+=nextChar;
			}
			else {
				int actualNum = Integer.parseInt(numberString);
				while(actualNum-->0)
					System.out.print(nextChar);
				numberString = "";
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("rishi.dat"));
		while(scan.hasNextLine()) {
			String nextLine = scan.nextLine();
			char firstChar = nextLine.charAt(0);
			if(Character.isDigit(firstChar)) {
				decode(nextLine);
			} else {
				encode(nextLine);
			}
		}
	}
}
