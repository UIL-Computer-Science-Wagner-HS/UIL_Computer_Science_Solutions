package Permutations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 
 * @author Ian Fernandes
 *
 */
public class pr150 {
	
	/**
	 * return the list of all permutations of the input string
	 * @param input
	 * @param length
	 * @return
	 */
	private static List<String> permute(String input) {
		List<String> set = new ArrayList<>();
		if(input.length()==1) {
			set.add(input);
			return set;
		}
		
		for(int i = 0;i<input.length();i++) {
			String remaining = input.substring(0,i)+input.substring(i+1);
			for(String s: permute(remaining)) {
				set.add((input.charAt(i)+s));
			}
		}
		return set;
	}

	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(new File("pr150.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while(no-->0) {
			String[] nextLine = scan.nextLine().split(" ");
			String input = nextLine[0];
			int length = Integer.parseInt(nextLine[1]);
			//Get all permutations
			List<String> set = permute(input);
			
			//Use a sorted set to store the first "length" letters of each permutation.
			TreeSet<String> firstTwo = new TreeSet<String>();
			set.forEach(x->firstTwo.add(x.substring(0,length)));
			for(String a: firstTwo)
				System.out.println(a);
			System.out.println();
		}
		scan.close();

	}

}
