import java.io.*;
import java.util.*;

import org.omg.Messaging.SyncScopeHelper;

public class pr57 {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("pr57.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		List<Person> list = new ArrayList();
		while(noSets-->0){
			String[] arr = scan.nextLine().trim().split("\\s+");
			String first;
			if(arr.length>2){
			 first ="";
			for(int i = 0; i<arr.length-1; i++)
				first+=arr[i]+" ";
			}
			else{
				 first = arr[0]+" ";
			}
			list.add(new Person(first, arr[arr.length-1]));
		}
		list.sort((a,b)->a.ln.compareTo(b.ln));
			list.forEach(a->System.out.println(a.ln+", "+a.fn));
			
			
			
		
		

	}
}
class Person{
	String fn;
	String ln;
	public Person(String fn, String ln) {
		super();
		this.fn = fn;
		this.ln = ln;
	}
	
	
	
	
}