// the goal here is to import a list of word and sort them based on a new alpha ordering. 
//newAlpha is our new ordering. 
//this uses a Comparator and it is recursive. 

import java.io.*;
import java.util.*;
public class SortByNewAlphabet {
	
	static String newAlpha = "zxcvbnmasdfghjklqwertyuiop";
static	Comparator<String> comp = (a,b)->	{
		if(a.length()==0||b.length()==0)
			return a.length()-b.length();
		if(a.charAt(0)!=b.charAt(0))
			return newAlpha.indexOf(a.charAt(0))-newAlpha.indexOf(b.charAt(0));
		return SortByNewAlphabet.comp.compare(a.substring(1), b.substring(1));
		
};
public static void main(String[] args) throws IOException{
	//Scanner scan = new Scanner(new File(""));
		//int noSets = scan.nextInt();
	List<String> list = Arrays.asList("werwer", "zoo", "abc", "d");
	System.out.println(list);
	list.sort(comp);
	System.out.println(list);
	

}
}
