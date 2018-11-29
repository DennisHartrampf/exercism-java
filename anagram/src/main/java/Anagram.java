import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

class Anagram {

    private final char[] chars;
    private final String word;

    Anagram(String word) {
        this.word = word;
        char[] chars = word
                           .toLowerCase()
                           .toCharArray();
        Arrays.sort(chars);
        this.chars = chars;
    }

    List<String> match(Collection<String> candidates) {
        List<String> anagrams = new LinkedList<>();
        for (String candidate : candidates) {
            if (!word.equalsIgnoreCase(candidate)) {
                char[] chars = candidate
                                   .toLowerCase()
                                   .toCharArray();
                Arrays.sort(chars);
                if (Arrays.equals(this.chars, chars)) {
                    anagrams.add(candidate);
                }
            }
        }
        return anagrams;
    }
}
