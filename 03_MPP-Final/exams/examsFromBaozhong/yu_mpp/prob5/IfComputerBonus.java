package prob5;

import java.time.LocalDate;

/**
 * Created by Paul on 2016/12/22.
 */
public interface IfComputerBonus {
     LocalDate getHireDate();

    default double computeBonus() {
        int hireYear = getHireDate().getYear();
        int thisYear = LocalDate.now().getYear();
        return 400 * (thisYear - hireYear);
    }
}
