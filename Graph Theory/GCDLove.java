
public class GCDLove {
static int gcd(int a, int b) {
	return b==0?a:gcd(b, a%b);
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(100,45));
	}

}
