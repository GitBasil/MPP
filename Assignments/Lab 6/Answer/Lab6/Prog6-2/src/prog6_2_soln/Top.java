package prog6_2_soln;

public class Top {
	int t = 1;
	Middle mid = new Middle();
	Middle.Bottom midbot = mid.new Bottom();
	//returns the value in the instance vble of Bottom
	int readBottom() {
		return midbot.b;
	}
	class Middle {
		int m = 2;
		//returns sum of instance vble in Top and 
		//instance vble in Bottom
		int addTopAndBottom() {
			return t + midbot.b;
		}
		class Bottom {
			int b = 3;
			//returns the product of the instance vbles
			//in all three classes
			int multiplyAllThree() {
				return t * b * m;
			}
		}
	}
	public static void main(String[] args){
		Top top = new Top();

		System.out.println(top.readBottom());
		System.out.println(top.mid.addTopAndBottom());
		System.out.println(top.midbot.multiplyAllThree());

	}
}