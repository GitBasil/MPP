package prog10_2_soln;

public class Rational {
	private int num;
	private int denom;
	public Rational(int num,int denom) {
		if(denom < 0) {
			System.out.println("Denominator must be Positive!");
			return;
		}
		this.num = num;
		this.denom = denom;
	}
	//returns –1 if this rational is less than rat
	//returns 0 if this rational equals (see equals method discussion below) rat
	//returns 1 if this rational is greater than rat
	public int compareTo(Rational rat) {
		int leftTotal = this.num * rat.denom;
        int rightTotal = this.denom * rat.num;
        if (leftTotal < rightTotal) return -1;
        if (leftTotal > rightTotal) return +1;
        return 0;
	}

    // is this Rational object equal to y?
	@Override
	public boolean equals(Object y) {
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Rational b = (Rational) y;
        return compareTo(b) == 0;
    }
    // hashCode consistent with equals() and compareTo()
    // (better to hash the numerator and denominator and combine)
	@Override
    public int hashCode() {
        return this.toString().hashCode();
    }
	//adds the rational rat to this Rational
	public Rational add(Rational rat) {
		int a = this.num;
		int b = this.denom;
		int c = rat.num;
		int d = rat.denom;
		return new Rational((a*d + b*c),b*d);
	}
	//multiplies rat by this Rational
	public Rational multiply(Rational rat) {
		int a = this.num;
		int b = this.denom;
		int c = rat.num;
		int d = rat.denom;
		return new Rational(a*c,b*d);
	}
	public int getNum() {
		return this.num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDenom() {
		return this.denom;
	}
	public void setDenom(int denom) {
		this.denom = denom;
	}
	public String toString() {
		if(denom==1) return ""+num;
		return ""+num+"/"+denom;
	}
	public double doubleValue() {
		return (double)num / (double)denom ;
	}
	public static void main(String[] args) {
		Rational twoThirds = new Rational(2, 3);
		Rational negSeventeenFifths = new Rational(-17, 5);
		//System.out.println("Expecting: 2/3 * -17/5 = -34/15");
		//System.out.println(twoThirds+" * "+negSeventeenFifths + " = " +twoThirds.multiply(negSeventeenFifths));
		Rational oneThird = new Rational(1, 3);
		Rational leftSide = (twoThirds.multiply(negSeventeenFifths)).add(oneThird);
		Rational righSide = twoThirds.multiply((negSeventeenFifths.add(oneThird)));
		String left = "("+twoThirds.toString()+" * "+negSeventeenFifths.toString()+") + "+oneThird.toString();
		String right = twoThirds.toString()+" * "+"("+negSeventeenFifths.toString()+" + "+oneThird.toString()+")";
		int compare = leftSide.compareTo(righSide);
		switch(compare) {
			case 0: 
				System.out.println(left+" equals "+right);
				break;
			case 1:
				System.out.println(left+" is greater than "+right);
				break;
			case -1:
				System.out.println(left+" is less than "+right);
				break;
		}
	}

}
