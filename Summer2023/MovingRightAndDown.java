//Note there is a math way of doing this.  Return ((r-1+c-1)!/((r-1)!*(c-1!));

import java.util.*;
public class MovingRightAndDown {
	static long gridRec(int r, int c) {
		if(r==0 || c==0)
			return 0;
		if(r==1 && c ==1)
			return 1;
		return gridRec(r-1,c)+gridRec(r,c-1);
		
		
		
	}
	static long gridMemo(int r, int c) {
		long[][] arr = new long[r][c];
		if(r==0||c==0) return 0;
		
		Arrays.fill(arr[0],1) ;
		for(int r1 = 0; r1<arr.length; r1++)
			arr[r1][0]= 1;
		
		
		for(int i=1; i<r; i++) {
			for(int j=1; j<c; j++) {
				arr[i][j]= arr[i][j-1]+arr[i-1][j];
			}
		}
		for(long[] row: arr)
			System.out.println(Arrays.toString(row));
		return arr[r-1][c-1];
	}
	
	public static void main(String[] args) {
		//System.out.println(gridRec(18,18));
		System.out.println(gridMemo(18,18));
	}

	
	
}
