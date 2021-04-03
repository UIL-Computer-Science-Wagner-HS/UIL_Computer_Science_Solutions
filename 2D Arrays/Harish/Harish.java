import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Harish {
	
	static char[][] maze;
	
	static boolean isGood(int row, int col) {
		return row >=0 && row <maze.length && col >=0 && col <maze[row].length;
	}

	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("Harish.dat"));
		int num = Integer.parseInt(scan.nextLine());
		while(num-->0) {
			maze = new char[5][5];
			int numA = 0;
			
			for(int r = 0;r<5;r++) {
				char[] nextLine = scan.nextLine().toCharArray();
				for(int c = 0;c<maze[r].length;c++) {
					if(nextLine[c]=='a')
						numA++;
					maze[r][c] = nextLine[c];
				}
			}
			
			scan.nextLine();
			
			if(numA!=9) {
				System.out.println("invalid");
			} else {
				boolean isGood = true;
				for(int r = 0;r<maze.length; r++) {
					for(int c = 0; c<maze[r].length; c++) {
						if(maze[r][c]=='a') {
							int newRow, newCol;
							
							//Up and to left
							newRow = r-2;
							newCol = c-2;
							if(isGood(newRow, newCol) && maze[newRow][newCol] == 'a')
								isGood = false;
							
							//Up and to right
							newRow = r-2;
							newCol = c+2;
							if(isGood(newRow, newCol) && maze[newRow][newCol] == 'a')
								isGood = false;
							
							//Down and to left
							newRow = r+2;
							newCol = c-2;
							if(isGood(newRow, newCol) && maze[newRow][newCol] == 'a')
								isGood = false;
							
							//Down and to right
							newRow = r+2;
							newCol = c+2;
							if(isGood(newRow, newCol) && maze[newRow][newCol] == 'a')
								isGood = false;
						}
					}
				}
				
				System.out.println(isGood?"valid":"invalid");
				
			}
			
		}

	}

}
