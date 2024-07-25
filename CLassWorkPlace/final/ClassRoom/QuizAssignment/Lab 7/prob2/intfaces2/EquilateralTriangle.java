package lesson5.lecture.intfaces2;

public class EquilateralTriangle implements Polygon {
    private double sideLength;

    public EquilateralTriangle(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double[] getSides() {
        return new double[] { sideLength, sideLength, sideLength };
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }
}
