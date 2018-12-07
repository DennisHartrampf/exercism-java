import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum YachtCategory {

    YACHT(YachtCategory::calculateScoreYacht),
    ONES(dice -> calculateScoreNs(dice, 1)),
    TWOS(dice -> calculateScoreNs(dice, 2)),
    THREES(dice -> calculateScoreNs(dice, 3)),
    FOURS(dice -> calculateScoreNs(dice, 4)),
    FIVES(dice -> calculateScoreNs(dice, 5)),
    SIXES(dice -> calculateScoreNs(dice, 6)),
    FULL_HOUSE(YachtCategory::calculateScoreFullHouse),
    FOUR_OF_A_KIND(YachtCategory::calculateScoreFourOfAKind),
    LITTLE_STRAIGHT(YachtCategory::calculateScoreLittleStraight),
    BIG_STRAIGHT(YachtCategory::calculateScoreBigStraight),
    CHOICE(YachtCategory::calculateScoreChoice);

    private final Function<int[], Integer> calculator;

    YachtCategory(Function<int[], Integer> calculator) {
        this.calculator = calculator;
    }

    int calculateScore(int[] dice) {
        return calculator.apply(dice);
    }

    private static int calculateScoreYacht(int[] dice) {
        var set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            set.add(dice[i]);
        }
        var match = set.size() == 1;
        return match ? 50 : 0;
    }

    private static int calculateScoreNs(int[] dice, int n) {
        return Arrays
                   .stream(dice)
                   .filter(value -> value == n)
                   .sum();
    }

    private static int calculateScoreFullHouse(int[] dice) {
        var counts = countDice(dice);
        var match = counts.containsValue(2) && counts.containsValue(3);
        return match ? counts
                           .entrySet()
                           .stream()
                           .mapToInt(entry -> entry.getKey() * entry.getValue())
                           .sum() : 0;
    }

    private static Map<Integer, Integer> countDice(int[] dice) {
        return getBoxedStream(dice).collect(Collectors.toMap(o -> (Integer) o,
                                                             integer -> 1,
                                                             (o, o2) -> o + o2));
    }

    private static int calculateScoreFourOfAKind(int[] dice) {
        var counts = countDice(dice);
        return counts
                   .entrySet()
                   .stream()
                   .mapToInt(entry -> entry.getValue() == 4 || entry.getValue() == 5
                                      ? entry.getKey() * 4 : 0)
                   .sum();
    }

    private static int calculateScoreLittleStraight(int[] dice) {
        return calculateScoreStraight(dice, 1);
    }

    private static int calculateScoreStraight(int[] dice, int additionalDice) {
        var diceSet = getBoxedStream(dice).collect(Collectors.toSet());
        var match = diceSet.contains(2)
                        && diceSet.contains(3)
                        && diceSet.contains(4)
                        && diceSet.contains(5)
                        && diceSet.contains(additionalDice);
        return match ? 30 : 0;
    }

    private static Stream<Integer> getBoxedStream(int[] dice) {
        return Arrays
                   .stream(dice)
                   .boxed();
    }

    private static int calculateScoreBigStraight(int[] dice) {
        return calculateScoreStraight(dice, 6);
    }

    private static int calculateScoreChoice(int[] dice) {
        return Arrays
                   .stream(dice)
                   .sum();
    }

}
