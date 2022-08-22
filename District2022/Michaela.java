import java.io.*;
import java.util.*;

public class Michaela {
	
	static String find(int n) {
		String s = Integer.toBinaryString(n);
		String ans = "";
		
		for(int i = 0; i<s.length(); i++) {
			if(s.charAt(i)=='1')
				ans+="-";
			else ans+=".";
				
		}
		return ans;
		
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("michaela.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		Map<Character, String> map = new HashMap<>();
		map.put(' ', "_.....");
		for(int i = 65; i<=90; i++)
			map.put((char)i, find(i+0));
	
		int caseNum = 1;
		while (noSets-- > 0) {
			System.out.print("Message #"+ caseNum++ +": " );
			char[] decode = scan.nextLine().toUpperCase().toCharArray();
		
			
			
			for(int i = 0; i<decode.length; i++) {
				System.out.print(map.get(decode[i])+" ");
			}
					System.out.println();
			

		}
	}

}
