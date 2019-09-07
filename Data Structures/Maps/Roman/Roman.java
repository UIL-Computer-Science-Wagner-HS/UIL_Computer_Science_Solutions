import java.util.*;

import java.io.*;

/**
*Convert a roman numeral to a decimal number (base 10) for the inputted data sets.
*/
public class Roman {

	public static void main(String[] args)throws IOException {

		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		map1.put('I', 1);
		map1.put('V', 5);
		map1.put('X', 10);
		map1.put('L', 50);
		map1.put('C', 100);
		map1.put('D', 500);
		map1.put('M', 1000);
		
		Scanner scan = new Scanner(new File("roman.dat"));
		int count = scan.nextInt();
		scan.nextLine();
		
		while(count-->0) {
		int total= 0;
		String input = scan.nextLine();
		for(int i =0; i <input.length(); i++) {
			if(i<input.length()-1 && map1.get(input.charAt(i)) < map1.get(input.charAt(i+1))) {
				total += (map1.get(input.charAt(i+1))- map1.get(input.charAt(i)));
				i++;
			}
			else
				total+= map1.get(input.charAt(i));
		}
		System.out.println(input + " = " + total);
		
	}
		scan.close();
	}
	}

