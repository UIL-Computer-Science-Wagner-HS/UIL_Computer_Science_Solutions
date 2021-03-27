import java.io.*;
import java.util.*;
public class Regina {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 60; j++) {
				if(j  < 20) {
					System.out.print("B");
				}
				else if (j < 40) {
					System.out.print("W");
				}
				else {
					System.out.print("R");
				}
			}
			System.out.println();
		}

	}

}
