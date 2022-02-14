import java.io.*;
import java.util.*;
public class Hannah {
	static int gcd(int a, int b){
		return b==0?a:gcd(b, a%b);
		
	}
	
public static void main(String...args) throws IOException{
	Scanner scan = new Scanner(new File("hannah"));
	int noSets = scan.nextInt();
	//scan.nextLine();
	while(noSets-->0){
		int base = scan.nextInt();
		
		String left = scan.next();
		String op = scan.next();
		String right = scan.next();
		int r = Integer.parseInt(right,base);
		int l = Integer.parseInt(left,base);
		String ans = "";
		switch(op){
		case "+": ans = Integer.toString(r+l, base); break;
		case "-":ans = Integer.toString(l-r, base); break;
		case "*": ans = Integer.toString(r*l, base); break;
		case "/": ans = Integer.toString(l/r, base); break;
		
		}
		System.out.println(left+" " +op+" "+right+" = "+ans);
		
		

		
		
	}
}
}