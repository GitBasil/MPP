package PlayGround;

import java.util.ArrayList;
import java.util.List;


//Bounded extends wild card

class employee {

}

class manager extends employee {

}

public class wildcard_1 {

    void check(List<? extends employee> emp)
    {

    }

    public static void main(String[] args) {
        wildcard_1 t = new wildcard_1();
        List<manager> managers = new ArrayList<>();
        t.check(managers);

        List< ? extends employee> emps = managers;
        // Limitation of extend wildcard that you cannot add but you can get
        // emps.add(new manager());
        employee emp = emps.get(0);
    }
    
}
