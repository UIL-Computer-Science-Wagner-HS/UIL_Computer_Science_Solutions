//state 2009
package cs3;
import java.io.*;
import java.util.*;


public class Vowels {
public static void main(String...args) throws IOException{
	Scanner scan = new Scanner(new File("vowels.dat"));
	int noSets = scan.nextInt();
	String[] arr = {"A", "E", "I", "O", "U"};
	while(noSets-->0){
		String str = scan.next();
		TreeSet<String> tree = new TreeSet<>();
		boolean allIn = false;
		for(String s: arr){
			if(!str.contains(s)){
				tree.add(s);
			
			}
		}
		
		if(tree.size()!=0){
			System.out.print("DOES NOT CONTAIN ");
			tree.forEach(a->System.out.print(a+" "));
			System.out.println();
		}
		else{
			if(str.matches(".*A.*E.*I.*O.*U.*"))
				System.out.println("ALL, IN ORDER");
			else System.out.println("ALL, NOT IN ORDER");
		}
	}
		
		
		
	}
}
