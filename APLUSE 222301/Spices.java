import java.io.*;
import java.util.*;



public class Spices {
	static List<List<Integer>> list;
	
	
	static void occupy(int[] nums, int index, List<Integer> add) {
		if(index == nums.length) {
			list.add(new ArrayList<Integer>(add));
			return;
		}
		
		List<Integer> lnew = new ArrayList<>(add);
		lnew.add(nums[index]);
		occupy(nums, index+1, lnew);//use nums[index]
		occupy(nums, index+1, new ArrayList<Integer>(add));//don;t use nums[index]
	}
	
	
	static boolean solve(int[] nums, int target) {
		for(List<Integer> l: list) {
			int sum = 0;
			for(int s: l)
				sum+=s;
			if(sum==target)
				return true;
			
			
		}
		
		return false;
		
		
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("spices.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		
		while (noSets-- > 0) {
			list = new ArrayList<>();
			String[] arr = scan.nextLine().split("\\s+");
			int nums[] = new int[arr.length];
			for (int i = 0; i < nums.length; i++)
				nums[i] = Integer.parseInt(arr[i]);
			int target = Integer.parseInt(scan.nextLine());
			occupy(nums,0, new ArrayList<Integer>());
			System.out.println(list);
			System.out.println(solve(nums, target)?"Blox be carzy":"Not on my Blox" );
		}

	}
}