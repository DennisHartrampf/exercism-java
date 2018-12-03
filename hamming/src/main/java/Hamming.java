class Hamming {

    private final int hammingDistance;

    Hamming(final String leftStrand, final String rightStrand) {
        verifyThatBothStrandsHaveSameLength(leftStrand, rightStrand);
        this.hammingDistance = calculateHammingDistance(leftStrand, rightStrand);
    }

    private void verifyThatBothStrandsHaveSameLength(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    private int calculateHammingDistance(String leftStrand, String rightStrand) {
        var hammingDistanceCounter = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            if (leftStrand.charAt(i) != rightStrand.charAt(i)) {
                hammingDistanceCounter++;
            }
        }
        return hammingDistanceCounter;
    }

    int getHammingDistance() {
        return this.hammingDistance;
    }

}
