import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class WordCount {

    private static final Pattern QUOTE_PATTERN = Pattern.compile("'+(.+)'+");
    private static final Pattern SPLIT_PATTERN = Pattern.compile("[^a-zA-Z0-9\\-']+");

    Map<String, Integer> phrase(String input) {
        return splitToWords(input).collect(toMapCounting());
    }

    private Stream<String> splitToWords(String input) {
        return SPLIT_PATTERN.splitAsStream(input.trim());
    }

    private Collector<String, ?, Map<String, Integer>> toMapCounting() {
        return Collectors.toMap(this::normalize, word -> 1, Integer::sum);
    }

    private String normalize(String word) {
        String normalized = word.toLowerCase();
        Matcher matcher = QUOTE_PATTERN.matcher(normalized);
        return matcher.matches() ? matcher.group(1) : normalized;
    }
}
