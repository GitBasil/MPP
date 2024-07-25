import java.util.List;

interface CountWordsIntf {
    public int countWords(List<String> words, char c, char d, int len);
}

class InnerCountWordsCls implements CountWordsIntf {

    @Override
    public int countWords(List<String> words, char c, char d, int len) {
       return (int) words.stream()
       .filter(word -> word.length() == len)
       .filter(word -> word.indexOf(c) >= 0)
       .filter(word -> word.indexOf(d) == -1)
       .count();
    }

    
}

public class CountWordsCls {
    public static void main(String[] args) {
        // Example usage
        CountWordsIntf wc = new InnerCountWordsCls();
        List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry");
        char c = 'b';
        char d = 'c';
        int len = 6;
        int result = wc.countWords(words, c, d, len);
        System.out.println("Number of words: " + result);
    }
}
