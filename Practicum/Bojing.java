import java.util.*;
import java.io.*;

public class Bojing {
public static void main(String[] args) throws FileNotFoundException {
	
	Scanner scan = new Scanner(new File("bojing.dat"));
	List<String> list = new ArrayList();
	while(scan.hasNext())
		list.add(scan.next());
	Set<String> set = new TreeSet();
	list.sort((a,b)->a.length()-b.length());
	int end = list.get(list.size()-1).length();
	for(int i = 1; i<=end; i++){
		for(String s: list)
			if(s.length()==i)
				set.add(s);
		if(!set.isEmpty()){
		   set.forEach(a->System.out.print(a+" "));
		System.out.println();}
		set = new TreeSet();
	}
	
} 
}
