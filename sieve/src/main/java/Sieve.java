import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

class Sieve {

    private final List<Integer> primes = new LinkedList<>();

    Sieve(int maxPrime) {
        if (maxPrime > 1) {
            int[] numbers = IntStream
                                .rangeClosed(2, maxPrime)
                                .toArray();
            findPrimes(numbers);
        }
    }

    private void findPrimes(int[] numbers) {
        findNextPrime(numbers).ifPresent(removeMultiplesOfPrime(numbers));
    }

    private IntConsumer removeMultiplesOfPrime(int[] numbers) {
        return prime -> {
            primes.add(prime);
            for (int i = prime - 2; i < numbers.length; i = i + prime) {
                numbers[i] = -1;
            }
            findPrimes(numbers);
        };
    }

    private OptionalInt findNextPrime(int[] numbers) {
        return Arrays
                   .stream(numbers)
                   .filter(value -> value > 0)
                   .findFirst();
    }

    List<Integer> getPrimes() {
        return primes;
    }
}
