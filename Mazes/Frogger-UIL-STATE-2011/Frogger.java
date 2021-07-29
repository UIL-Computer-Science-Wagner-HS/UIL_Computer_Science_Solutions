import java.io.*;
import java.util.*;

public class Frogger {
	static int[][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("frogger.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0){
			int rows = scan.nextInt();
			int cols = scan.nextInt();
			char[][] mat = new char[rows][cols];
			PF start = null;
			PF end = null;
			for(int i = 0; i<rows; i++){
				mat[i]= scan.next().toCharArray();
				for(int j = 0; j<cols; j++){
					if(mat[i][j]=='$')
						 start = new PF(i,j,0);
					if(mat[i][j]=='@')
						 end = new PF(i,j,0);
					
				}
					
			}
			boolean[][] visited = new boolean[rows][cols];
			Queue<PF> queue = new LinkedList();
			queue.add(start);
			visited[start.r][start.c]=true;
			int counter = 0;
			while(!queue.isEmpty()){
				PF check = queue.poll();
				if(check.r==end.r&&check.c==end.c){
					System.out.println(check.steps+1);
					break;
				}
				else{
					int move = 1;
					String val = ""+mat[check.r][check.c];
					if(val.matches("\\d"))
						move = Integer.parseInt(val)+1;
					
					for(int j = 0; j<4; j++){
						int cX = check.r+move*moves[j][0];
						int cY = check.c+move*moves[j][1];
					if(cX>=0&&cY>=0&&cX<mat.length&&cY<mat[0].length&&visited[cX][cY]==false&&mat[cX][cY]!='*'){
						visited[cX][cY]=true;
						queue.add(new PF(cX,cY,check.steps+1));
						
					}
						
					}
				
				
				
			}
			
			
			
			
		}
		
	}
}
}
class PF{
	int r;
	int c;
	
	int steps;
	public PF(int r, int c,  int steps) {
		super();
		this.r = r;
		this.c = c;
		
		this.steps= steps;
	}
}
	
	
	
	
