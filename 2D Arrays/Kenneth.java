import java.io.*;
import java.util.*;

public class Kenneth {
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new File("kenneth.dat"));
		int grid = 1;
		int noSets = scan.nextInt();
		//scan.nextLine();
		while(noSets-->0){
			char[][] arr = new char[9][9];
			String key = "123456789";
			List<Integer> ansRows = new ArrayList();
			List<Integer> ansCols = new ArrayList();
			for(int i = 0; i<9; i++){
				for(int j = 0; j<9; j++)
					arr[i][j]= scan.next().charAt(0);
			// now look at rows
			}
			
			
			for(int i = 0; i<9; i++){
			char[] testRow = new char[0];
			testRow = Arrays.copyOf(arr[i], 9);
			Arrays.sort(testRow);
			String test = String.valueOf(testRow);
			if(!test.equals(key))
				ansRows.add(i+1);
			}
			
			//System.out.println(ansRows);
			
			for(int col = 0; col<9; col++){
				String test ="";
				for(int row = 0; row<9; row++)
					test+=arr[row][col];
				char[] testCol = test.toCharArray();
				Arrays.sort(testCol);
				test = String.valueOf(testCol);
				if(!test.equals(key))
					ansCols.add(col+1);
				
			}
		if(ansCols.size()+ansRows.size()==0)
			System.out.println("GRID #"+grid++ +": SOLUTION IS CORRECT");
		else {
			System.out.println("GRID #"+grid++ +": NOT A SOLUTION");
			System.out.print(">> ROWS WITH ERRORS: ");
			if(ansRows.size()==0)
				System.out.println("NONE");
			else{
				for(int i: ansRows)
					System.out.print(i+" ");
				System.out.println();
			}
			System.out.print(">> COLUMNS WITH ERRORS: ");
				if(ansCols.size()==0)
					System.out.println("NONE");
				else{
					for(int i: ansCols)
						System.out.print(i+" ");
					System.out.println();
					
						
				}
			
			
		}
		System.out.println("===========");
			
		
		}
		
	}

}
