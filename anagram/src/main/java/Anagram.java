import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

class Anagram {

    private final char[] chars;
    private final String word;

    Anagram(String word) {
        this.word = word;
        var chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        this.chars = chars;
    }

    List<String> match(Collection<String> candidates) {
        List<String> anagrams = new LinkedList<>();
        for (var candidate : candidates) {
            if (!word.equalsIgnoreCase(candidate)) {
                var chars = candidate.toLowerCase().toCharArray();
                Arrays.sort(chars);
                if (Arrays.equals(this.chars, chars)) {
                    anagrams.add(candidate);
                }
            }
        }
        return anagrams;
    }
}
