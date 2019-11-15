import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Constanza {
	
	private static void printMap(HashMap<String, Integer> colors) {
		int noRed = colors.get("red");
		int noOrange = colors.get("orange");
		int noYellow = colors.get("yellow");
		int noGreen = colors.get("green");
		int noBlue = colors.get("blue");
		int noIndigo = colors.get("indigo");
		int noViolet = colors.get("violet");
			
		System.out.printf("%-7s","red");
		for(int i = 0;i<noRed;i++) {
			System.out.print("*");
		}
		System.out.println();
		
		System.out.printf("%-7s","orange");
		for(int i = 0;i<noOrange;i++) {
			System.out.print("*");
		}
		System.out.println();
		
		System.out.printf("%-7s","yellow");
		for(int i = 0;i<noYellow;i++) {
			System.out.print("*");
		}
		System.out.println();
		
		System.out.printf("%-7s","green");
		for(int i = 0;i<noGreen;i++) {
			System.out.print("*");
		}
		System.out.println();
		
		System.out.printf("%-7s","blue");
		for(int i = 0;i<noBlue;i++) {
			System.out.print("*");
		}
		System.out.println();
		
		System.out.printf("%-7s","indigo");
		for(int i = 0;i<noIndigo;i++) {
			System.out.print("*");
		}
		System.out.println();
		
		System.out.printf("%-7s","violet");
		for(int i = 0;i<noViolet;i++) {
			System.out.print("*");
		}
		System.out.println();
		

	}
	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(new File("constanza.dat"));
		HashMap<String, Integer> colors = new HashMap<>();
		while(scan.hasNextLine()) {
			String nextLine = scan.nextLine();
			if(colors.containsKey(nextLine)) {
				colors.put(nextLine, colors.get(nextLine)+1);
			} else {
				colors.put(nextLine, 1);
			}
		}
		
		printMap(colors);
	}
}
/*
yellow
orange
green
indigo
green
blue
orange
red
violet*/
