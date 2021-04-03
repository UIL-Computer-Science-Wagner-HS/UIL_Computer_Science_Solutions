import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Melissa {
	
	static int getVal(int input) {
		String stringVersion = ""+input;
		if(stringVersion.length()==1) {
			return input;
		}
		int product = 1;
		for(int i = 0; i<stringVersion.length(); i++) {
			char currChar = stringVersion.charAt(i);
			if(currChar!='0') {
				product *= Integer.parseInt(Character.toString(currChar)); 
			}
		}
		return getVal(product);
	}
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("melissa.dat"));
		int num = Integer.parseInt(scan.nextLine());
		while(num-->0) {
			int input = Integer.parseInt(scan.nextLine());
			System.out.println(input + " -> "+ getVal(input));
		}
	}
}
