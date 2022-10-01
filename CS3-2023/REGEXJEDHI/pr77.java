package cs3;
import java.io.*;
import java.util.*;
public class pr77 {
	static String ast(String s){
		String ans = "";
		for(int i = 0; i<s.length(); i++)
			ans+="*";
		return ans;
		
	}
public static void main(String...args) throws IOException{
	Scanner scan = new Scanner(new File("pr77.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	
	while(noSets-->0){
		String str = scan.nextLine();
		String str1 = str.replaceAll("[N-Z]"," ");
		System.out.println(str1);
		str1 = str.replaceAll("[A-M]"," ");
		System.out.println(str1);
		System.out.println();
		
	}
	scan.close();
	scan =  new Scanner(new File("pr79.dat"));
	String[] arr = scan.nextLine().split("\\s+");
	String str2 = scan.nextLine();
	String s3 = "";
	for(String s: arr){
	
		str2 = str2.replaceAll("(?i)"+s,ast(s) );
		
	}
	System.out.println(str2);
	
		
		
	}
}
