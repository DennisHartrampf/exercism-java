import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        List<Signal> signals = new LinkedList<>();
        if (isNthBitSetIn(0, number)) {
            signals.add(Signal.WINK);
        }
        if (isNthBitSetIn(1, number)) {
            signals.add(Signal.DOUBLE_BLINK);
        }
        if (isNthBitSetIn(2, number)) {
            signals.add(Signal.CLOSE_YOUR_EYES);
        }
        if (isNthBitSetIn(3, number)) {
            signals.add(Signal.JUMP);
        }
        if (isNthBitSetIn(4, number)) {
            Collections.reverse(signals);
        }
        return signals;
    }

    private boolean isNthBitSetIn(int bit, int number) {
        int twoRaisedToBit = 1 << bit;
        return (number & twoRaisedToBit) == twoRaisedToBit;
    }

}
