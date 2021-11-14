import java.io.*;
import java.util.*;

public class Homework {
	static List<City> list = new ArrayList();
	

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("homewoark.dat"));
		while (scan.hasNext()) {
			String state = scan.next();
			String cap = scan.next();
			double x = scan.nextDouble();
			double y = scan.nextDouble();
			list.add(new City(cap + ", " + state, x, y));

		}
		double [][] arr = new double[list.size()][list.size()];
			for(int i = 0; i<list.size(); i++){
				for(int j = 0; j<list.size(); j++){
					double dist = Math.sqrt((list.get(i).x-list.get(j).x)*(list.get(i).x-list.get(j).x)+
							(list.get(i).y-list.get(j).y)*(list.get(i).y-list.get(j).y))*150;
					arr[i][j]= dist;
					
				}
				arr[i][i]=10000;
	}
			List<String> ans = new ArrayList();
			int indexX = 0;
			int indexY= 0;
			double min;
			done:
			while(true){
				min = 1000;
			for(int i = 0; i<list.size(); i++){
				for(int j = 0; j<list.size(); j++){
					if(arr[i][j]<min){
						indexX = i;
						indexY = j;
						min = arr[i][j];
						
					}
					
				}
			}
			String input = list.get(indexX).name+ " to "+list.get(indexY).name+" distance is "+
					((int) (10*arr[indexX][indexY]+.5)/10.0);
			ans.add(input);
			arr[indexX][indexY]=10000;
			arr[indexY][indexX]=10000;
			if(ans.size()==5)
				break done;
			}
			
			ans.sort((a,b)->Double.parseDouble(a.substring(a.length()-5))>
				Double.parseDouble(b.substring(b.length()-5))?1:-1);
			for(String s: ans)
				System.out.println(s);
}
		
}
class City {
	String name;
	double x;
	double y;
	City neighbor;

	public City(String name, double x, double y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
	}

}
