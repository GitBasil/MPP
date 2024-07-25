package questions.Final2015July.src.prob5;

import java.time.LocalDate;

public interface Default {
	LocalDate getHireDate();

	default double computeBonus() {
		int hireYear = getHireDate().getYear();
		int thisYear = LocalDate.now().getYear();
		return 400 * (thisYear - hireYear);
	}

}
