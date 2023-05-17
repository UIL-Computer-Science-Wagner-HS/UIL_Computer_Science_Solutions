
import java.util.*;
public class tictactoe {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int counter = 0;
		boolean win = false;
		Scanner scan = new Scanner(System.in);
		String[][] ttt = new String[3][3];
        int index = 1;
		for(int i = 0; i<3;i++) {
			for(int j = 0; j<3;j++) {
				ttt[i][j] =  Integer.toString((i+1)*(j+1));
			}
		}
		while (won(ttt).equals("go")) {
			System.out.println("enter row");
			int row = scan.nextInt();
			System.out.println("enter col");
			int col = scan.nextInt();
		    if(col>=3||row>=3||ttt[row][col].equals("o")||ttt[row][col].equals("x")) {
		    	System.out.println("try again");
		    	for(int i = 0; i<3;i++) {
					for(int j = 0; j<3;j++) {
						System.out.print(ttt[i][j]);
						System.out.print(" ");
					}
					System.out.println();
				}
		    	continue;
		    }
		    ttt[row][col] = "o";
		    counter++;
		    if(counter >= 9) {
		    	break;
		    }
		    int botrow = (int)(Math.random()*3);
		    int botcol = (int)(Math.random()*3);
		    while(ttt[botrow][botcol].equals("o")||ttt[botrow][botcol].equals("x")) {
		    	botrow = (int)(Math.random()*3);
			    botcol = (int)(Math.random()*3);
		    }
		    ttt[botrow][botcol] = "x";
		    counter++;
		    for(int i = 0; i<3;i++) {
				for(int j = 0; j<3;j++) {
					System.out.print(ttt[i][j]);
					System.out.print(" ");
				}
				System.out.println();
			}
		    if(counter >= 9) {
		    	break;
		    }
		}
		if(!won(ttt).equals("go")) {
			System.out.print(won(ttt));
		}else {
			System.out.print("tie");
		}
			
		
	}
	public static String won(String[][] match) {
		String res = "go";
		int winrow = 0;
		int wincol = 0;
		if(match[0][1].equals(match[1][1])&&match[1][1].equals(match[2][1])) {
			res = "won";
			winrow = 1;
			wincol = 1;
			
		}
		if(match[0][2].equals(match[1][2])&&match[1][2].equals(match[2][2])) {
			res = "won";
			winrow = 1;
			wincol = 2;
		}
		if(match[0][0].equals(match[1][0])&&match[1][0].equals(match[2][0])) {
			res = "won";
			winrow = 1;
			wincol = 0;
		}
		if(match[1][1].equals(match[1][2])&&match[1][2].equals(match[1][0])) {
			res = "won";
			winrow = 1;
			wincol = 2;
		}
		if(match[0][0].equals(match[0][1])&&match[0][1].equals(match[0][2])) {
			res = "won";
			winrow = 0;
			wincol = 1;
		}
		if(match[2][0].equals(match[2][1])&&match[2][1].equals(match[2][2])) {
			res = "won";
			winrow = 2;
			wincol = 1;
		}
		if(match[0][0].equals(match[1][1])&&match[1][1].equals(match[2][2])) {
			res = "won";
			winrow = 1;
			wincol = 1;
		}
		if(match[0][2].equals(match[1][1])&&match[1][1].equals(match[2][0])) {
			res = "won";
			winrow = 1;
			wincol = 1;
		
		}
		if(res.equals("won")) {
		if(match[winrow][wincol].equals("x")) {
			res = "lost";
		}
		}
		return res;
	}

}
