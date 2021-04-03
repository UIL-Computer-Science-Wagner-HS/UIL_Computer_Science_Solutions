import java.io.*;
import java.util.*;
public class Joyce1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("joyce.dat"));
		int noSets=scan.nextInt();
		scan.nextLine();
		while(noSets-->0){
			int[] charArr = new int[26];
			String inp = scan.nextLine().toLowerCase().replaceAll("[^a-z]", "");
			System.out.println(inp);
			for(int i = 0; i<inp.length(); i++)
				charArr[inp.charAt(i)-97]++;
			int sum = 0;
			boolean hasMoreThanOne = false;
			String missingLetters ="";
			for(int i = 0; i<26; i++){
				if(charArr[i]==0)
					missingLetters=missingLetters + (char)(i+97);
				if(charArr[i]>1)
					hasMoreThanOne=true;
			}
			
			if(missingLetters.length()==0 && !hasMoreThanOne)
				System.out.println("perfect panagram");
			else if (missingLetters.length()==0)
				System.out.println("panagram");
			else
				System.out.println("missing "+missingLetters);
			
			
			
		}

	}

}
