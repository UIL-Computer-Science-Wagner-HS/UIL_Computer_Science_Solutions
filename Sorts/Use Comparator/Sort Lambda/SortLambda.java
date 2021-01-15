import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

//Example of using Comparator with lambda to sort an ArrayList of Objects
public class SortLambda {
String name;
int ID;

//Constructor built by Eclipse/Source/Generate Constructor using fields
public SortLambda(String name, int iD) {
	super();
	this.name = name;
	ID = iD;
	
}
static Comparator<SortLambda> comp = (a,b)-> b.name.compareTo(a.name); //ie reverse alpha order 
static Comparator<SortLambda> compID = (a,b)->a.ID-b.ID; //natural ordering 

	public static void main(String[] args) {
		ArrayList<SortLambda> list = new ArrayList();
		list.add(new SortLambda("bill", 299)); 
		list.add(new SortLambda("ill", 27));
		list.add(new SortLambda("aill", 28));
		Collections.sort(list,comp);
		for(SortLambda t:list)
			System.out.print(t.name+"/");
		System.out.println();
		Collections.sort(list,compID);
		for(SortLambda t:list)
			System.out.print(t.name+"/");
		
	}

	
	}



