package One.prob5;

import java.time.LocalDate;

public interface Bonus {
	LocalDate getHireDate();
	default double computeBonus() {
		int hireYear = getHireDate().getYear();
		int thisYear = LocalDate.now().getYear();
		return 400 * (thisYear - hireYear);
	}

}
