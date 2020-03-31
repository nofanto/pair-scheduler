package pair.scheduler;

import java.util.Collections;
import java.util.List;

public class Schedule {

    private List<String> pairs;
    private int iterationNumber;

    public Schedule(List<String> pairs, int iterationNumber) {
        this.pairs = pairs;
        this.iterationNumber = iterationNumber;
    }

    public String printPairs() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.pairs.size(); i++) {
            result.append("pair-" + i + " : " + this.pairs.get(i) + "\n");
        }

        return result.toString();
    }

    public int totalPair() {
        return this.pairs.size();
    }

    public int iterationNumber() {
        return this.iterationNumber;
    }

    public List<String> pairs() {
        return Collections.unmodifiableList(this.pairs);
    }
}
