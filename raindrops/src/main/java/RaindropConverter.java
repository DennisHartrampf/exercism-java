class RaindropConverter {

    String convert(int number) {
        StringBuilder result = new StringBuilder();
        if (isDivisibleBy(number, 3)) {
            result.append("Pling");
        }
        if (isDivisibleBy(number, 5)) {
            result.append("Plang");
        }
        if (isDivisibleBy(number, 7)) {
            result.append("Plong");
        }
        return result.length() > 0 ? result.toString() : String.valueOf(number);
    }

    private boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }

}
