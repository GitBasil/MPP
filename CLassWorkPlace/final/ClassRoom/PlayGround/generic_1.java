package PlayGround;

public class generic_1 <K,V> {

    private K key;
    private V value;

    public generic_1(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }

    public static void main(String[] args) {
        generic_1<Integer,String> t = new generic_1<Integer,String>(1, "basil");
        System.out.println(t.getKey());
        System.out.println(t.getValue());
    }

}