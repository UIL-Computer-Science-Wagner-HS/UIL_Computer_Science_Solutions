import java.io.*;
import java.util.*;



public class Megan {
	static String key;
	static Comparator<String> comp = (a,b)->{
		if(a.length()==0||b.length()==0)
			return a.length()-b.length();
		if(a.charAt(0)!=b.charAt(0))
			return
				key.indexOf(a.charAt(0))-key.indexOf(b.charAt(0));	
		return Megan.comp.compare(a.substring(1), b.substring(1));	
			
		};
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("megan.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();int count = 1;
		while(noSets-->0) {
			 key = scan.nextLine();
			String[] arr = scan.nextLine().split(",");
			List<String> original = new ArrayList();
			List<String> sorted = new ArrayList();
			for(String s: arr) {
				sorted.add(s);
				original.add(s);
				
			}
			
			sorted.sort(comp);
			System.out.print("Word List "+ count++ + " is ");
			if(sorted.equals(original))
					System.out.println("sorted.");
			else
				System.out.println("not sorted.");
				
					
			
			
		}
			
		
}
	
}
