import java.util.HashSet;
import java.util.Set;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        final Set<Character> seenCharacters = new HashSet<>();
        for (Character character : phrase.toCharArray()) {
            if (Character.isAlphabetic(character) && !seenCharacters.add(Character.toLowerCase(
                character))) {
                return false;
            }
        }
        return true;
    }

}
