import java.io.*;
import java.util.*;
public class Elevator {
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("elevator.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while(noSets-->0) {
			String[]arr = scan.nextLine().split("\\s+");
			int count = 0;
			int i = 0;
			for(; i<arr.length; i++) {
				count+=Integer.parseInt(arr[i]);
				if(count>=2000)
					break;
					
			}
			System.out.println(i);
			
			
		}
		
}

}