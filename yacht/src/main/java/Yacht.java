class Yacht {

    private final int score;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.score = yachtCategory.calculateScore(dice);
    }

    int score() {
        return score;
    }

}
