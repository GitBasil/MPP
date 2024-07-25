package prog7_1_soln;

public class Exponential {
	double total = 0;
	public void exponential() {
		
	}
	public double power(double x,int n) {
		//if(n==1) return total * x;
		if(n==0 && total==0) return 1;
		if(n > 0) {
			if(total==0) {
				total = x;
				n--;
			}
			total *= x;
			return power(x,n-1);
		}
		return total;
	}
}
