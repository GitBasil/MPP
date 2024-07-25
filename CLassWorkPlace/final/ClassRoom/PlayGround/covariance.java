package PlayGround;

import java.util.ArrayList;
import java.util.List;

public class covariance {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);

        // this will generate error because of covariance
        // but if it was arrays it will work but list as we said it will not
        // List<Number> nums = ints; 
        // nums.add(3.14);
        // System.out.println(ints);  

    }
}
