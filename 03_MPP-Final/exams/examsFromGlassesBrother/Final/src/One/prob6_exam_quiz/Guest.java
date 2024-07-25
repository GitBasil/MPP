package One.prob6_exam_quiz;


public class Guest {
	private String name;
	private int numYearsKnown;
	private boolean planningToCome;
	public Guest(String name, int numYearsKnown, boolean willAttend) {
		this.name = name;
		this.numYearsKnown = numYearsKnown;
		this.planningToCome = willAttend;
	}
	@Override
	public String toString() {
		return "[Guest Name: " + name + " known for " + numYearsKnown + " years]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNumYearsKnown() {
		return numYearsKnown;
	}
	public void setNumYearsKnown(int numYearsKnown) {
		this.numYearsKnown = numYearsKnown;
	}
	public boolean isPlanningToCome() {
		return planningToCome;
	}
	public void setPlanningToCome(boolean planningToCome) {
		this.planningToCome = planningToCome;
	}
	
}
