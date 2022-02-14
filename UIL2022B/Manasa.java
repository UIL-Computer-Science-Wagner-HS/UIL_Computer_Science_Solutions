import java.io.*;
import java.util.*;
public class Manasa {
public static void main(String...args) throws IOException{
	Scanner scan = new Scanner(new File("manasa.dat"));
	int noSets = scan.nextInt();
	int count = 1;
	while(noSets-->0){
		int vel = scan.nextInt();
		int secs = scan.nextInt();
		int wVel = scan.nextInt();
		int rest= scan.nextInt();
		int dist = scan.nextInt();	
		//System.out.println(dist);
		 if((long)(vel)*secs>=dist)
			System.out.println("Case #"+(count++)+": "+1);
		 else if(vel*secs<=wVel*rest)
			 System.out.println("Case #"+(count++)+": Impossible");
		else{
			int travelled = 0;
			int i = 0;
			for( i = 0; i<=1000000000; i++){
				travelled +=vel*secs;
				if(travelled>=dist){
					System.out.println("Case #"+(count++)+": "+(i+1));
					break;
				}
				travelled-=wVel*rest;
			}
			
		}
	}
}
}