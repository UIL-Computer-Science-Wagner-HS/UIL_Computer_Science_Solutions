import java.io.*;
import java.util.*;

public class Rohit {
	rNode root;
	
	static void fill(List<rNode> bigList, int counter, int num, List<rNode> lev1, List<rNode> lev2) {
		//List lev2 = new ArrayList<>();
		for(int i = 0; i<lev1.size(); i++) {
			for(int j = 0; j<num; j++) {
				rNode temp = new rNode(counter++);
				lev1.get(i).list.add(temp);
				lev2.add(temp);
				
			}
				
			
			
		}
		bigList.addAll(lev1);
		lev1 = lev2;
		
		
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("rohit.dat"));
		int noSets = scan.nextInt();
		scan.nextLine();
		while(noSets-->0) {
			String[] arr = scan.nextLine().trim().split("\\s+");
			int[] nums = new int[arr.length];
			for(int i = 0; i<arr.length; i++)
				nums[i] = Integer.parseInt(arr[i]);
			System.out.println(Arrays.toString(nums));
			int target = Integer.parseInt(scan.nextLine());
			int counter = 1;
			List<rNode> bigList = new ArrayList<>();
			Rohit obj = new Rohit();
			obj.root = new rNode(1);
			List<rNode> lev1 = new ArrayList<>();
			lev1.add(obj.root);
			for(int i = 0; i<arr.length; i++) {
				 List<rNode> lev2 = new ArrayList<rNode>();
				fill(bigList, counter++, nums[i], lev1,  lev2);
				
			}
			for(rNode n : bigList)
				System.out.print(n.name+" ");
			System.out.println();
			
			
			
		}
	}

}

class rNode{
	int name;
	List<rNode> list = new ArrayList<>();
	public rNode(int name) {
		super();
		this.name = name;
	}
	
	
	
	
}