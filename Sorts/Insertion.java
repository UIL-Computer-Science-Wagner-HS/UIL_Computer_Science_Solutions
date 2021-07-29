import java.util.*;
import java.io.*;
//this problem asks us to do an insertion sort based on a curated ordering and print out the array after each pass
//Instead of doing it the right way we cheat here by building a comparator and then letting Arrays sort do the sorting.
public class Insertion {
	// map will store the values of each of the inputs
	static Map<String,Integer> map = new HashMap();
	static Comparator<String> comp = (a,b)->{
		int valA = 0;
		if(a.matches("\\d+"))
			valA = Integer.parseInt(a);
		else
			valA = map.get(a);
		int valB = 0;
		if(b.matches("\\d+"))
			valB = Integer.parseInt(b);
		else
			valB = map.get(b);
		return valA-valB;
		
	};
	public static void main(String[] args) throws FileNotFoundException {
		map.put("T", 10);
		map.put("J", 11);
		map.put("Q", 12);
		map.put("K", 13);
		map.put("A", 14);
		Scanner scan = new Scanner(new File("insertion.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while(noSets-->0){
			String[] arr = scan.nextLine().split(" ");
			for(int i = 1;i<arr.length; i++){
				String[] temp = new String[i+1];
				for(int j=0; j<i+1; j++)
					temp[j]= arr[j];
				// this sorts the 0 through i elements 
				Arrays.sort(temp,comp);
				//now copy these 0 through i elements into the array
			for(int j = 0; j<i+1; j++)
				arr[j]= temp[j];
				//print the pass results
			for(String s: arr)
				System.out.print(s+" ");
			System.out.println();
				
			}
			
			
		}
		
		
}
}
