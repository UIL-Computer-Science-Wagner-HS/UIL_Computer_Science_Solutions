import java.io.*;
import java.util.*;
public class All {
	static ArrayList<int[]> list = new ArrayList();
	static ArrayList<int[]> tryAll(int[] arr){
		int n = 2<<(arr.length-1);
		for(int i=1; i<n+1; i++) {
			int[] ind = new int[arr.length];
			for(int j=0;j<arr.length; j++) {
				if((i&(1<<j))!=0) {
					//System.out.println("i "+i+ "j: "+j);
					ind[j]=1;
				//System.out.println("i; "+i+ "   j: "+j);
				}
			}
			
			list.add(ind);
		}
		
		
		
		return list;
		
	}
	
	
	public static void main(String[] args) throws IOException{
		//Scanner scan = new Scanner(new  File(""));
		int[] arr = {1,1,2,2,2};
		 ArrayList<int[]> list1 = tryAll(arr);
		 int ans =0;
		 for (int[] a: list) {
			 int sum =0;
			 for(int i=0; i<arr.length; i++) {
				 if(a[i]==1)
					 sum+=arr[i];
				}
			 if(sum==4)
				 ans++;
			 
		 }
			 System.out.println(ans);

	}

}

