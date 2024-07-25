package PlayGround;

import java.util.ArrayList;
import java.util.List;

public class wildcard_3 {
    public static void reverse(List<?> list) { 
        List<Object> tmp = new ArrayList<Object>(list); 
        rev(tmp);
    }

    public static <T> void rev(List<T> list){
        for (int i = 0; i < list.size(); i++) { 
            list.set(i, list.get(list.size()-i-1));
            } 
    }

}
