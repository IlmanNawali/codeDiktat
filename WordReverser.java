public class WordReverser {
    String word;

    public static String reverseWord(String word) {
        StringBuilder sb = new StringBuilder(word);
        sb.reverse();
        return sb.toString();
    }
}
