import java.io.*;
import java.util.*;

public class Palindromes {
	static void process(Map<String, Integer> map) {
		for(Map.Entry<String, Integer> ent: map.entrySet()) {
			if(ent.getValue()<2) {
				System.out.println(ent.getKey());
			}
			else {
				System.out.println(ent.getKey()+" ("+ent.getValue()+")");
			}
			
		}
			
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pal.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		label:
		while(noSets-->0) {
			List<String> list= new ArrayList<>();
			Map<String, Integer> map = new TreeMap<>();
			while(true) {
			String[] arr = scan.nextLine().split("[\\s.,]+");
			if(arr[0].charAt(0)=='-') {
				process(map);
				System.out.println(); 
				continue label;
			}
			for(String s: arr) {
				StringBuilder sb = new StringBuilder(s).reverse();
				if(s.length()>1&&sb.toString().equals(s)) {
				map.putIfAbsent(s, 0);
				map.put(s, map.get(s)+1);
				}
			}
			
			
			}
		}
	}

}
