import java.io.*;
import java.util.*;
public class Damien {
	static boolean grow(int i){
		char[] arr = (i+"").toCharArray();
		for(int j = 0; j<arr.length-1; j++)
			if(arr[j]>=arr[j+1])
				return false;
		
		return true;
	}
public static void main(String...args) throws IOException{
	Scanner scan = new Scanner(new File("damien.dat"));
	int noSets = scan.nextInt();
	while(noSets-->0){
		int check = scan.nextInt();
		//System.out.println(check);
		for(int i = 1; i<=check/2; i++)
			if(check%i==0&&grow(i))
				System.out.print(i+" ");
		System.out.println();
	}
		
		
		
	}
}
