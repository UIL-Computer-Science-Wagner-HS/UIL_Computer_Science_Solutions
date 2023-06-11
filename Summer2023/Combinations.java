import java.io.*;
import java.util.*;

public class Combinations {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new File("combinations.dat"));
		int cases = file.nextInt();
		file.nextLine();
		while(cases-->0)
		{	
			int money = file.nextInt();
	        int size = file.nextInt();
	        long[] arr = new long[size];
	        for(int i =0; i < size; i++)
	        {
	               arr[i] = file.nextLong();
	        }
	        
	        long[] z = new long[money+1];
	        z[0] =1;
	        for(int i =0; i < arr.length; i++)
	        {
	            for(long k = arr[i]; k <= money ; k++)
	            {
	                z[(int)k] += z[(int)(k-arr[i])];
	               
	            }
	        }
	        System.out.println(z[z.length-1]);
	        
		}

	}

}
