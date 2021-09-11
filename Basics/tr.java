
public class tr {
public static void main(String[] args) {
	int x = 3;
	int y = 7*++x *5/x-- +--x;
	int y1, y2, y3 = 0;
	System.out.println(y);
	x = 3;
	y = 7*(++x*5/x--) +--x;
	System.out.println(y);		
	
	x = 3;
	y = 7*(y1=++x) *5/(y2=x--) +(y3=--x);
	System.out.println("y1 "+y1);
	System.out.println("y2 "+ y2);
	System.out.println("y3 "+y3);
			
	System.out.println(x);
	
			
		
			
	
	
	
	
	
	int n = x++ + 1<<++x;
	System.out.println(n);
	System.out.println(x);
	
}
}
