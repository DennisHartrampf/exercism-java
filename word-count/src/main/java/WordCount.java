import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class WordCount {

    private static final Pattern QUOTE_PATTERN = Pattern.compile("'+(.+)'+");
    private static final String SPLIT_PATTERN = "[^a-zA-Z0-9\\-']+";

    Map<String, Integer> phrase(String input) {
        return splitToWords(input).collect(toMapCounting());
    }

    private Stream<String> splitToWords(String input) {
        return Arrays.stream(input.trim().split(SPLIT_PATTERN));
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
