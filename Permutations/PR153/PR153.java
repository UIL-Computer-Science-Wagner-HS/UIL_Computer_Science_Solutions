import java.io.*;
import java.util.*;

public class PR153 {
 static Set<String> set = new TreeSet();
 
 static void add(char[] arr) {
	 for(int i = 1; i<(1<<arr.length); i++) {
		 String toAdd="";
		 for(int j = 0; j<arr.length; j++)
			 if((i&(1<<j))!=0)
				 toAdd+=arr[j];
		 if(toAdd.length()>0)
			 set.add(toAdd);
		 
		 
		 
	 }
	 
	 
 }
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("pr153.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0) {
			String str= scan.next();
			char[] arr = str.toCharArray();
			add(arr);
			for(String s: set)
				System.out.println(s);
			
			if(noSets>0)
				System.out.println();
		}

	}

}
