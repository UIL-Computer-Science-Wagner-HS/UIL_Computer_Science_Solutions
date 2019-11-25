import java.io.*;
import java.util.*;

public class PR1544 {
 static Set<String> set = new TreeSet();
 
 static int add(int[] arr, int sum) {
	 int total = 0;
	 for(int i = 1; i<(1<<arr.length); i++) {
		 int tempSum=0;
		 for(int j = 0; j<arr.length; j++)
			 if((i&(1<<j))!=0)
				 tempSum+=arr[j];
		 if(tempSum==sum)
			 total++;
		 
		
		 
	 }
	 return total;
	 
 }
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("pr154.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0) {
			int sum = scan.nextInt();
			scan.nextLine();
			String str = scan.nextLine();
			String[] arr = str.split("\\s+");
			int[] checkArr = new int[arr.length];
			for(int i = 0; i<arr.length; i++) 
				checkArr[i]= Integer.parseInt(arr[i]);
			if(add(checkArr,sum)>0)
				System.out.println("YES");
			else
				System.out.println("NO");
				
					
		}

	}

}
