import java.io.*;
import java.util.*;
public class Justin {
public static void main(String...args) throws IOException{
	Scanner scan = new Scanner(new File("justin.dat"));
	int noSets = scan.nextInt();
	while(noSets-->0){
		double a = scan.nextDouble();
		double dp = scan.nextDouble();
		double apr = scan.nextDouble()/12/100;
		int n = scan.nextInt();
		double p = (a-dp)*apr/(1-Math.pow(1+apr,-n));
		p = (int)(p*100+0.5)/100.0;
		//System.out.println(p);
		double finalCost = dp+n*p;
		double intPaid = finalCost-a;
		System.out.printf("$%9.2f  $%9.2f $%9.2f\n", p,finalCost, intPaid);
		
		
		
	}
		
		
		
	}
}
