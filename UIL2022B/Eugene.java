import java.io.*;
import java.util.*;
public class Eugene {
	static int gcd(int a, int b){
		return b==0?a:gcd(b, a%b);
		
	}
public static void main(String...args) throws IOException{
	Scanner scan = new Scanner(new File("eugene.dat"));
	int noSets = scan.nextInt();
	//scan.nextLine();
	while(noSets-->0){
		List<Integer> list = new ArrayList<>();
	String fn = scan.next();
	String ln = scan.next();
	char finit = (char) (fn.charAt(0)+32);
	char linit = (char) (ln.charAt(0)+32);
	int fnum = fn.charAt(0)+0;
	int lnum = ln.charAt(0)+0;
	while(list.contains(fnum))
		fnum++;
	list.add(fnum);
	System.out.println(fn+" "+ln+ " "+finit+linit+fnum+lnum);
		
	
	}
}
}