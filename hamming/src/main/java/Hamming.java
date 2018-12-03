class Hamming {

    private final int hammingDistance;

    Hamming(final String leftStrand, final String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
        this.hammingDistance = calculateHammingDistance(leftStrand, rightStrand);
    }

    private int calculateHammingDistance(String leftStrand, String rightStrand) {
        final var leftChars = leftStrand.toCharArray();
        final var rightChars = rightStrand.toCharArray();
        var hammingDistanceCounter = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftChars[i] != rightChars[i]) {
                hammingDistanceCounter++;
            }
        }
        return hammingDistanceCounter;
    }

    int getHammingDistance() {
        return this.hammingDistance;
    }

}
