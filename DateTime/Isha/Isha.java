import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Isha {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("isha.dat"));
		scan.nextLine();
		Map<String, Integer> map = new TreeMap();
		map.put("H", 2);
		map.put("C", 0);
		map.put("D", 1);
		map.put("O", 3);
		map.put("S", 4);
		int[][] adj = new int[5][5];
		adj[0][2]= 70;
		adj[0][3]= 89;
		adj[0][4]= 83;
		adj[1][2]= 185;
		adj[1][4]= 59;
		adj[2][0]= 190;
		adj[2][1]= 65;
		adj[2][3]= 181;
		adj[2][4]= 54;
		adj[3][0]= 89;
		adj[3][2]= 61;
		adj[4][0]= 443;
		adj[4][1]= 239;
		adj[4][2]= 239;
		adj[4][3]= 294;
		
		while(scan.hasNextLine()) {
			String[] arr = scan.nextLine().split("[ :]");
			//System.out.println(Arrays.toString(arr));
			LocalTime t1 = LocalTime.of(Integer.parseInt(arr[1]),Integer.parseInt(arr[2]));
			if(arr[3].charAt(0)=='P')
				t1=t1.plusHours(12);
			if(arr[4].equals("San"))
				arr[4]= "San Diego";
			t1=t1.plusMinutes(adj[map.get(arr[0].substring(0,1))][map.get(arr[4].substring(0,1))]);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
			String ans = t1.format(formatter).toString();
			if(ans.contains("AM"))
				ans = ans.substring(0,ans.length()-2)+"A.M.";
			else
				ans = ans.substring(0,ans.length()-2)+"P.M.";
			
			System.out.println(arr[0]+" "+arr[1]+":"+arr[2]+" "+arr[3]+" "+ arr[4]+" "+ans);
			
			
			
			
			
		}

	}

}
