import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Melanie {
	
	static int factorial(int num) {
		if(num==1)
			return 1;
		return num*factorial(num-1);
	}
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("melanie.dat"));
		int num = Integer.parseInt(scan.nextLine());
		while(num-->0) {
			String word = scan.nextLine();
			HashMap<Character, Integer> mappings = new HashMap<>();
			for(int i = 0; i<word.length();i++) {
				char currChar = word.charAt(i);
				if(mappings.containsKey(currChar)) {
					int currNum = mappings.get(currChar);
					mappings.put(currChar, currNum+1);
				} else {
					mappings.put(currChar, 1);
				}
			}
			
			int result = factorial(word.length());
			
			for(char key: mappings.keySet()) {
				int currNum = mappings.get(key);
				result/=factorial(currNum);
			}
			System.out.println(result);
		}
	}
}
