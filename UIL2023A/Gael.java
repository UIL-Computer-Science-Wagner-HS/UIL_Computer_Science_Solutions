import java.io.*;
import java.util.*;
public class Gael {
public static void main(String...args) throws IOException{
	Scanner scan = new Scanner(new File("gael.dat"));
	int noSets = scan.nextInt();
	while(noSets-->0){
		String str = scan.next();
		char[][] arr= new char[str.length()][str.length()];
		char[] s = str.toCharArray();
		for(int i = 0; i<str.length(); i++)
			arr[0][i]= s[i];
		for(int i = 1; i<str.length(); i++)
			arr[i][0]= s[i];
		for(int i = 0; i<str.length(); i++)
			arr[s.length-1][s.length-1-i]= s[i];
		for(int i = 0; i<str.length(); i++)
			arr[s.length-1-i][s.length-1]= s[i];
		
		for(char[] row:arr){
			for(char c: row)
				if(c>64)
					System.out.print(c);
				else System.out.print(" ");
		
		System.out.println();
		}
				
	}
		
		
		
	}
}
