import java.io.*;
import java.util.*;
public class Arthur {
public static void main(String...args) throws IOException{
	Scanner scan = new Scanner(new File("arthur.dat"));
	int noSets = scan.nextInt();
	while(noSets-->0){
		int [] arr = new int[3];
	 arr[0] = scan.nextInt();
	 arr[1] = scan.nextInt();
	 arr[2] = scan.nextInt();	
	 Arrays.sort(arr);
	 System.out.println(arr[0]*arr[0]+arr[1]*arr[1]==arr[2]*arr[2]?
			 arr[0]+", "+arr[1]+", "+arr[2]+" is a Pythagoran triple.":
				 arr[0]+", "+arr[1]+", "+arr[2]+" is not a Pythagoran triple." );
		
	}
}
}
