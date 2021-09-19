import java.io.*;
import java.util.*;
public class Bryce {
public static void main(String[] args) throws FileNotFoundException {
	Scanner scan = new Scanner(new File("bryce.dat"));
	while(scan.hasNextInt()){
	int n = scan.nextInt();
	String ans = "";
	if(n/1000>0){
		for(int i = 0; i<n/1000; i++)
			ans+="M";
		n%=1000;
	}
	if(n>=900){
		ans+="CM";
		n=n-900;
	}
	if(n/500>0){
		ans+="D";
		n-=500;
	}
	if(n>=100){
		for(int i = 0; i<n/100; i++)
			ans+="C";
	n=n%100;
	}
	if(n>=90){
		ans+="XC";
		n=n-90;
	}
	if(n>=50){
		ans+="L";
		n=n-50;
	}
	if(n>=10){
		for(int i = 0; i<n/10; i++)
			ans+="X";
	n=n%10;
		
	}
	if(n==9){
		ans+="IX";
		n-=9;
	}
	if(n>=5){
		ans+="V";
		n-=5;
	}
	if(n==4){
		ans+="IV";
		n=n-4;
	}
	//System.out.println(n);
	if(n>0){
		for(int i = 0; i<n; i++)
			ans+="I";
		
	}
	System.out.println(ans);
	}
}
}
