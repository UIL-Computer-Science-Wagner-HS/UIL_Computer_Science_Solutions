import java.io.*;
import java.util.*;

public class Facundo {
	static void roll(char[] arr, int n) {
		char[] top;
		char[] bot;
		if(arr.length%2==0) {
			top = new char[arr.length/2];
			bot = new char[arr.length/2];
		
		
		while (n-->0) {
			for(int i = 0;  i<top.length; i++) {
				top[i]= arr[i];
				}
			for(int i = top.length, t = 0;  i<arr.length; i++) {
				bot[t++]= arr[i];
				}
			for(int i = 1, t = 0; i<arr.length; i+=2, t++)
				arr[i]=top[t];
			for(int i = 0, t = 0; i<arr.length-1; i+=2, t++)
				arr[i]=bot[t];
		}
	}
		else {
			top = new char[arr.length/2+1];
			bot = new char[arr.length/2];
			while (n-->0) {
				for(int i = 0;  i<top.length; i++) {
					top[i]= arr[i];
					}
				for(int i = top.length, t = 0;  i<arr.length; i++) {
					bot[t++]= arr[i];
					}
				for(int i = 0, t = 0; i<arr.length; i+=2, t++)
					arr[i]=top[t];
				for(int i = 1, t = 0; i<arr.length-1; i+=2, t++)
					arr[i]=bot[t];
			}
			
		}
		
	}
	
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("facunda.dat"));
		int noSets = scan.nextInt();
		while(scan.hasNext()) {
			char[] all = scan.next().toCharArray();
			int noRolls = scan.nextInt();
			roll(all, noRolls);
			for(char c: all)
				System.out.print(c);
			System.out.println();
			
			
		}
		
}
}
