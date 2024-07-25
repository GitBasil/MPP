package PlayGround;

import java.util.Optional;

public class OptionalSingleton {
    private static Optional<OptionalSingleton> instance;
    private OptionalSingleton() {};
    public static OptionalSingleton getInstance() {
        if(instance.isEmpty()){
            instance = Optional.ofNullable(new OptionalSingleton());
        }
        
        return instance.get();
    }
}

/**
 * OptionalWithEnum
 */
enum OptionalWithEnum {
    INSTANCE;
    public void behaviour(){
        System.out.println("hello");
    }
}