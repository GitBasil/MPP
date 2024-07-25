package PlayGround;

import java.util.ArrayList;
import java.util.List;


//Bounded super wild card

class employee {

}

class manager extends employee {

}

public class wildcard_2 {

    void check(List<? super manager> emp)
    {

    }

    public static void main(String[] args) {
        wildcard_2 t = new wildcard_2();
        List<employee> employees = new ArrayList<>();
        t.check(employees);

        List< ? super manager> emps = employees;
        // Limitation of extend wildcard that you cannot add but you can get
        // employee emp = emps.get(0);
        emps.add(new manager());
    }
    
}
