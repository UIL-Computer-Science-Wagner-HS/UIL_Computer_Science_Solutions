import java.io.*;
import java.util.*;
public class Denis {
	static int gcd(int a, int b){
		return b==0?a:gcd(b, a%b);
		
	}
public static void main(String...args) throws IOException{
	Scanner scan = new Scanner(new File("denis.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	while(noSets-->0){
	String[]arr= scan.nextLine().split("/");
	//System.out.println(Arrays.toString(arr));
	int a = Integer.parseInt(arr[0]);
	int b = Integer.parseInt(arr[1]);
	int gcd = gcd(a,b);
	int a1 = Math.abs(a/gcd); 
	int b1 = Math.abs(b/gcd);
	String sign = "";
	if(1.0*a/b<0)
		sign = "-";
	String ans = a+"/"+b+" reduced is "+sign+a1+"/"+b1;
	System.out.println(ans);
		
	
		
	}
}
}