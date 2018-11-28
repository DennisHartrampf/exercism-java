import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PigLatinTranslator {
    private static final String VOWELS = "\\b(\\w)y\\b";
    private static final String NON_VOWELS = "\\b(?:[aeiou]|xr|yt).*";
    private static final String Y_AFTER_CONSONANT_CLUSTER = "\\b([^aeiou]+)y.*";
    private static final String Y_AS_SECOND_IN_TWO_CHAR_WORD = "\\b([^aeiou]qu|qu|[^aeiou]+).*";

    private static final Map<Pattern, BiFunction<Matcher, String, String>> RULES = new LinkedHashMap<>();

    static {
        RULES.put(Pattern.compile(VOWELS), (matcher, word) -> String.format("y%say", matcher.group(1)));
        RULES.put(Pattern.compile(NON_VOWELS), (matcher, word) -> String.format("%say", word));
        RULES.put(Pattern.compile(Y_AFTER_CONSONANT_CLUSTER), PigLatinTranslator::ssay);
        RULES.put(Pattern.compile(Y_AS_SECOND_IN_TWO_CHAR_WORD), PigLatinTranslator::ssay);
    }

    private static String ssay(Matcher matcher, String word) {
        return String.format("%s%say", word.substring(matcher.end(1)), matcher.group(1));
    }

    String translate(String sentence) {
        final List<String> pigLatinWords = new LinkedList<>();

        for (final var word : sentence.split("\\W+")) {
            pigLatinWords.add(translateWord(word));
        }

        return String.join(" ", pigLatinWords);
    }

    private String translateWord(String word) {
        for (final var entry : RULES.entrySet()) {
            var matcher = entry.getKey().matcher(word);
            if (matcher.matches()) {
                return entry.getValue().apply(matcher, word);
            }
        }
        throw new IllegalStateException("No matching rule found.");
    }

}
