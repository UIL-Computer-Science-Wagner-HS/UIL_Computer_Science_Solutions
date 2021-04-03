import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Joyce {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("joyce.dat"));
		
		int num = Integer.parseInt(scan.nextLine());
		while(num-->0) {
			Map<Character, Integer> mappings = new HashMap<>();
			char currChar = 'a';
			while(currChar<='z') {
				mappings.put(currChar, 0);
				currChar += 1;
			}
			
			String currString = scan.nextLine();
			for(int i = 0; i<currString.length(); i++) {
				char myChar = Character.toLowerCase(currString.charAt(i));
				if(mappings.containsKey(myChar)) {
					int currCount = mappings.get(myChar);
					mappings.put(myChar, currCount+1);
				}
			}
			
			boolean all1 = true;
			boolean allGreaterThan0 = true;
			ArrayList<Character> notGreaterThan0 = new ArrayList<>();
			for(char key: mappings.keySet()) {
				int val = mappings.get(key);
				if(val!=1)
					all1 = false;
				if(val==0) {
					allGreaterThan0 = false;
					notGreaterThan0.add(key);
				}
			}
			
			if(all1) {
				System.out.println("perfect pangram");
			} else if(allGreaterThan0) {
				System.out.println("pangram");
			} else {
				System.out.print("missing ");
				notGreaterThan0.forEach(System.out::print);
				System.out.println();
			}
			
			
		}
	}

}
