import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Isaac {
	
	static void display(ArrayList<String> fileNames) {
		char[][] indices = new char[3][60];
		for(int i = 1; i<=60; i++) {
			String stringVersion = ""+i;
			if(stringVersion.length()==1) {
				indices[1][i-1] = stringVersion.charAt(0);
			} else {
				indices[0][i-1] = stringVersion.charAt(0);
				indices[1][i-1] = stringVersion.charAt(1);
			}
			indices[2][i-1] = '-';
		}
		for(char[] row: indices)
			System.out.println(row);
		
		Collections.sort(fileNames);
		int maxLength = Integer.MIN_VALUE;
		for(String file: fileNames)
			if(file.length()>maxLength)
				maxLength = file.length();
		
		int numOfColumns = (60-maxLength)/(maxLength+2) + 1;
		String[][] output = new String[(int)Math.ceil(1.0*fileNames.size()/numOfColumns)][numOfColumns];
		for(int c = 0; c<output[0].length; c++) {
			for(int r = 0; r<output.length; r++) {
				if(fileNames.size()==0)
					output[r][c] = "";
				else
					output[r][c] = fileNames.remove(0);
			}
		}
		
		int rightMostColumn = output[0].length-1;
		while(output[0][rightMostColumn]=="")
			rightMostColumn--;
		
		for(String[] row: output) {
			for(int i = 0; i<row.length; i++) {
				if(row[i]=="")
					System.out.print("");
				else if(i==rightMostColumn)
					System.out.printf("%-"+maxLength+"s", row[i]);
				else
					System.out.printf("%-"+(maxLength+2)+"s", row[i]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("Isaac.dat"));
		int n = Integer.parseInt(scan.nextLine());
		for(int i = 1; i<=n; i++) {
			int numFiles = Integer.parseInt(scan.nextLine());
			ArrayList<String> fileNames = new ArrayList<>();
			while(numFiles-->0)
				fileNames.add(scan.next());
			scan.nextLine();
			System.out.println("Case "+i);
			display(fileNames);
		}
	}
}
