import java.io.*;
import java.util.*;

import org.omg.Messaging.SyncScopeHelper;

public class pr56 {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("pr56.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while(noSets-->0){
			String[] arr = scan.nextLine().trim().split("\\s+");
			int[] nums = new int[arr.length];
			for(int i = 0; i<arr.length; i++)
				nums[i]= Integer.parseInt(arr[i]);
			Arrays.sort(nums);
			List<Integer> list1 = new ArrayList();
			 for(int i = 0; i<arr.length; i+=2)
				 list1.add(nums[i]);
			 
			List<Integer> list2 = new ArrayList();
			for(int i = 1; i<arr.length;i+=2)
				list2.add(0,nums[i]);
			list1.addAll(list2);
			System.out.println(list1);
				
			}
				
			
			
			
		
		

	}
}
